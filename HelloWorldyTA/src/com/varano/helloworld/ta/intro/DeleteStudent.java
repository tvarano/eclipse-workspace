//Thomas Varano
//Nov 12, 2018

package com.varano.helloworld.ta.intro;

public class DeleteStudent {
//		public static Student[] deleteStudentData(Student[] studs, int id) {
//			Student[] ret;
//			int x = 0;
//			for (int i = 0; i < studs.length; i++) {
//				if (studs[i].getIdentification() == id) {
//					return concat
//				}
//			}
//		}
		
		private static Student[] concat(Student[] a, Student[] b) {
			Student[] ret = new Student[a.length + b.length];
			int amt = Math.max(a.length, b.length);
			for (int i = 0; i < amt; i++) {
				if (i < a.length)
					ret[i] = a[i];
				if (i < b.length)
					ret[ret.length - i] = b[b.length - i - 1];
			}
			
			return ret;
		}
}
