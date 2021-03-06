/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exmaralda.alignment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.exmaralda.partitureditor.fsm.FSMException;
import org.exmaralda.partitureditor.jexmaralda.BasicTranscription;
import org.exmaralda.partitureditor.jexmaralda.Event;
import org.exmaralda.partitureditor.jexmaralda.JexmaraldaException;
import org.exmaralda.partitureditor.jexmaralda.Tier;
import org.exmaralda.partitureditor.jexmaralda.Timeline;
import org.exmaralda.partitureditor.jexmaralda.TimelineItem;
import org.exmaralda.partitureditor.jexmaralda.convert.PraatConverter;
import org.exmaralda.webservices.MAUS4EXMARaLDA;
import org.exmaralda.webservices.MAUSConnector;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;

/**
 *
 * @author Thomas_Schmidt
 * FineAligner takes an aligned EXB transcript
 * and uses WebMaus to fine align all events 
 * whose duration exceeds a certain minimum length
 */
public class FineAligner {
    
    BasicTranscription transcription;
    double maximumIntervalLength = 10.0;
    double minimumIntervalLength = 5.0;
    double MAX_ALIGNABLE_DURATION = 120.0;

    public FineAligner(BasicTranscription transcription) {
        this.transcription = transcription;
    }

    public BasicTranscription getTranscription() {
        return transcription;
    }

    public void setTranscription(BasicTranscription transcription) {
        this.transcription = transcription;
    }

    public double getMaximumIntervalLength() {
        return maximumIntervalLength;
    }

    public void setMaximumIntervalLength(double maximumIntervalLength) {
        this.maximumIntervalLength = maximumIntervalLength;
    }

    public double getMinimumIntervalLength() {
        return minimumIntervalLength;
    }

    public void setMinimumIntervalLength(double minimumIntervalLength) {
        this.minimumIntervalLength = minimumIntervalLength;
    }
    
    
    
    public void doFineAlignment() throws JexmaraldaException, IOException, JDOMException, SAXException, FSMException{
        transcription.getBody().removeUnusedTimelineItems();
        Timeline timeline = transcription.getBody().getCommonTimeline();
        for (int i=0; i<timeline.getNumberOfTimelineItems()-1; i++){
            TimelineItem thisTimelineItem = timeline.getTimelineItemAt(i);
            TimelineItem nextTimelineItem = timeline.getTimelineItemAt(i+1);
            
            // not possible to do anything if the interval is not aligned to the recording
            if ((nextTimelineItem.getTime()<0) || (thisTimelineItem.getTime()<0)) continue;
            
            // no need to do anything if this interval is short enough
            if ((nextTimelineItem.getTime() - thisTimelineItem.getTime())<maximumIntervalLength) continue;
            
            // don't try if the interval is too long
            if ((nextTimelineItem.getTime() - thisTimelineItem.getTime())>MAX_ALIGNABLE_DURATION) {
                System.out.println("Interval is too long: " + thisTimelineItem.getID());
                continue;
            }

            // now it is clear that the current interval is longer than minimum
            ArrayList<Event> eventsForThisInterval = new ArrayList<Event>();
            String tierID = "";
            for (int j=0; j<transcription.getBody().getNumberOfTiers(); j++){
                Tier tier = transcription.getBody().getTierAt(j);
                Vector<Event> eventsForThisTier = tier.getEventsIntersecting(timeline, thisTimelineItem.getID(), nextTimelineItem.getID());
                if (!eventsForThisTier.isEmpty()){
                    for (Event e : eventsForThisTier){
                        eventsForThisInterval.add(e);
                    }
                    tierID = tier.getID();
                }
                if (eventsForThisInterval.size()>1) break;
            }
            if (eventsForThisInterval.size()!=1) continue;
            
            // this is for the case that the only event here merely intersects the interval
            if (!transcription.getBody().getTierWithID(tierID).containsEventAtStartPoint(thisTimelineItem.getID())) continue;
            
            // don't act if this is not a transcription tier!
            if (!(transcription.getBody().getTierWithID(tierID).getType().equals("t"))) continue;
            
            // now it is clear that there is only a single transcription event for this interval
            Event event = transcription.getBody().getTierWithID(tierID).getEventAtStartPoint(thisTimelineItem.getID());
            //System.out.println(event.toXML());
            
            // decompose the event description into tokens and memorise the indices of individual words
            String eventDescription = event.getDescription();
            Pattern p = Pattern.compile("[\\p{IsLetter}]+");
            Matcher m = p.matcher(eventDescription);
            ArrayList<Integer> tokenIndices = new ArrayList<Integer>();
            String text = "";
            while (m.find()){
                int i1 = m.start();
                int i2 = m.end();
                String token = eventDescription.substring(i1,i2);
                //System.out.println(token);
                tokenIndices.add(i1);
                text+=token + " ";
            }
            text = text.trim();
            // if there are no letters (=phonemes) we can't align
            if (text.length()==0) continue;
            // if there is just one word, something's dodgy, so we better do not align
            if (!(text.contains(" ")))continue;
            
            System.out.println("TEXT: " + text);
            // prepare a text file
            File textFile = File.createTempFile("EXMARaLDA_MAUS", ".TXT");
            textFile.deleteOnExit();
            FileOutputStream fos = new FileOutputStream(textFile);
            fos.write(text.getBytes("UTF-8"));
            fos.close();                    
            
            // prepare a wav file
            MAUS4EXMARaLDA m4e = new MAUS4EXMARaLDA();
            File wavFile = new File(transcription.getHead().getMetaInformation().getReferencedFile());
            File audioFile = m4e.convertAudioFileToMono(m4e.cutAudioFile(wavFile, thisTimelineItem.getTime(), nextTimelineItem.getTime()));
            
            // do da WebMaus!
            MAUSConnector mc = new MAUSConnector();
            HashMap<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("LANGUAGE", "deu");

            
            // get the result as praat text grid string and write it to a temp file
            String result = mc.callMAUS(textFile, audioFile, null);
            File temp = File.createTempFile("MAUSRESULT", ".textGrid");
            temp.deleteOnExit();
            FileOutputStream fos2 = new FileOutputStream(temp);
            fos2.write(result.getBytes("UTF-8"));
            fos2.close();                    


            PraatConverter pc = new PraatConverter();
            BasicTranscription alignedTranscription = pc.readPraatFromFile(temp.getAbsolutePath(), "UTF-8");
            alignedTranscription.getHead().getMetaInformation().setReferencedFile(audioFile.getAbsolutePath());
            alignedTranscription.getBody().removeTierAt(2);
            alignedTranscription.getBody().removeTierAt(1);
            alignedTranscription.getBody().removeUnusedTimelineItems();
            alignedTranscription.getBody().removeAllGaps();
            //bt2.writeXMLToFile("C:\\Users\\Thomas_Schmidt\\Desktop\\MausOut2.exb", "none");
            
            // now all words should be events in the only tier left, no pauses
            //Tier theOnlyTier = alignedTranscription.getBody().getTierAt(0);
            
            Timeline alignedTimeline = alignedTranscription.getBody().getCommonTimeline();
            int index = 0;
            while (index<alignedTimeline.getNumberOfTimelineItems()-1 && alignedTimeline.getTimelineItemAt(index).getTime()<minimumIntervalLength){
                index++;
            }
            
            // not sure why this would happen, but it happens
            if (index>=tokenIndices.size()) continue;
            
            int charOffset = tokenIndices.get(index);
            
            String desc1 = eventDescription.substring(0, charOffset);
            String desc2 = eventDescription.substring(charOffset);
            System.out.println(desc1 + " --- " + desc2);

            double halfTime = thisTimelineItem.getTime() + alignedTimeline.getTimelineItemAt(index).getTime();
            System.out.println(halfTime);

            TimelineItem tliNew = new TimelineItem();
            tliNew.setID(timeline.getFreeID());
            tliNew.setTime(halfTime);
            tliNew.setType("intp");
            timeline.insertAccordingToTime(tliNew);
            i--;

            event.setEnd(tliNew.getID());
            event.setDescription(desc1);

            Event newEvent = new Event();
            newEvent.setStart(tliNew.getID());
            newEvent.setEnd(nextTimelineItem.getID());
            newEvent.setDescription(desc2);

            transcription.getBody().getTierWithID(tierID).addEvent(newEvent);

            transcription.getBody().getTierWithID(tierID).sort(timeline);
            
            
            
        }
        
    }
    
    
}
