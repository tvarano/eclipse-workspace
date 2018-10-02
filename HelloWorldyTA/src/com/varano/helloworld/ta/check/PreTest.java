//Thomas Varano
//Aug 31, 2018

package com.varano.helloworld.ta.check;

import javax.swing.JOptionPane;


public class PreTest {
	public static void main(String[] args) {
		System.out.println(JOptionPane.showOptionDialog(null, "Do you want to save?",
            "SAV", JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE, null,
            null, null));
	}
	
	public static int myst(int x) {
		if (x<= 0) return 5;
		else return x + myst(x - 2);
	}
	
	public static int check() {
		return 5 / 10 + 10 % 7;
	}
}
