//Thomas Varano
//Sep 17, 2018

package com.varano.helloworld.personal;

import javax.swing.JOptionPane;

public class NotifcationShower {
	
	public static void showNotification(String str) throws Exception {
		Process p = new ProcessBuilder().command("chmod", "755", "/Users/varanoth/Desktop/TestNotif.app/Contents/Resources/notifScript.sh").start();
		p.waitFor();
		p = new ProcessBuilder().command("sh", "/Users/varanoth/Desktop/TestNotif.app/Contents/Resources/notifScript.sh").start();
		p.waitFor(); 
	}
	
	public static void main(String[] args) {
		try {
			showNotification("trying this?");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "uh oh spaghettios" + e);
		}
	}
}
