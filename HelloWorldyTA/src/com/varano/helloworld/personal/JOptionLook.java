//Thomas Varano
//Oct 10, 2018

package com.varano.helloworld.personal;

import javax.swing.JOptionPane;



public class JOptionLook {
	public static void main(String[] args) {
		JOptionPane.showOptionDialog(null,
				"Would you like to use the default\nschedule location or choose another schedule?",
				"Agenda" + ": Choose Schedule", JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE, null, new String[] {"Default", "Another Schedule"}, "Default");
		
		
//      JOptionPane.showInputDialog(null, 
//      		"Would you like to use the default\nschedule location or choose another schedule?", "Agenda" + ": Choose Schedule",
//      		JOptionPane.INFORMATION_MESSAGE, null, new String[] {"Default", "Another Schedule"}, 0);
      
      
//		JOptionPane.showDialog(null,
//				"Would you like to use the default\nschedule location or choose another schedule?",
//				"Agenda" + ": Choose Schedule",
//				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
	}
}
