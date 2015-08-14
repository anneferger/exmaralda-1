/*
 * OpenAction.java
 *
 * Created on 14. Mai 2008, 14:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.exmaralda.folker.actions.eventviewactions;

import org.exmaralda.folker.actions.AbstractApplicationAction;
import java.awt.event.ActionEvent;
import javax.swing.*;
import org.exmaralda.folker.application.ApplicationControl;


/**
 *
 * @author thomas
 */
public class AppendEventAction extends AbstractApplicationAction {
    
    /** Creates a new instance of OpenAction */
    public AppendEventAction(ApplicationControl ac, String name, Icon icon) {
        super(ac, name, icon);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("[*** AppendEventAction ***]");
        ((ApplicationControl)(applicationControl)).appendEvent();
    }
    
}
