//Thomas Varano
//Oct 9, 2018

package com.varano.helloworld.personal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class ASOpener {
	public static void main(String[] args) {
		try {
			Process p = new ProcessBuilder("osascript", "/Users/varanoth/Documents/ScheduleImport.scpt").start();			
			
			String s = null;
			BufferedReader br = new BufferedReader(
					new InputStreamReader(p.getInputStream()));
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
			
			br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
			
			p.waitFor();
			System.out.println(p.exitValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
