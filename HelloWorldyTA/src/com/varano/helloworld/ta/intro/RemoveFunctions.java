//Thomas Varano
//Oct 16, 2018

package com.varano.helloworld.ta.intro;

public class RemoveFunctions {
	public static String removeAll(String str, String target) {
		if (str.indexOf(target) == -1)
			return str;
		return removeAll(remove(str, target), target);
	}
	
	public static String remove(String str, String target) {
		if (str.indexOf(target) == -1)
			return str;
		return str.substring(str.indexOf(target)) + str.substring(str.indexOf(target) + target.length());
	}
}
