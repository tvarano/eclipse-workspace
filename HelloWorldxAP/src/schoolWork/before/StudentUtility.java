package schoolWork.before;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

//Thomas Varano
//[Program Descripion]
//Oct 17, 2017

public class StudentUtility
{
   
   public static Student[] studentsInGradeLevel(Student[] students, int grade) {
      ArrayList<Student> ret = new ArrayList<Student>();
      for (Student s : students) {
         if (s.getGradeLevel() == grade)
            ret.add(s);
      }
      return ret.toArray(new Student[ret.size()]);
   }
   
   public static ArrayList<Student> studentsInGradeLevel(ArrayList<Student> a, int grade) {
      ArrayList<Student> ret = new ArrayList<Student>();
      for (Student s : a) 
         if (s.getGradeLevel() == grade)
            ret.add(s);
      a.clone();
      return ret;
   }
   
   public static void printStudentData(ArrayList<Student> a) {
      for (Student s : a) 
         System.out.println(s);
   }
   
   public static Student[] delete(int IDNum, Student[] a) {
      Student[] ret = new Student[a.length-1];
      int index = 0;
      for (int i = 0; i < a.length; i++) {
         if(index == ret.length)
            return a;
         if (a[i].getIDNumber() != IDNum) {
            ret[index] = a[i];
            index++;
         }
      }
      return ret;
   }
   
   public static ArrayList<Student> delete(int IDNum, ArrayList<Student> a) {
      for (Student s : a)
         if (s.getIDNumber() == IDNum)
            a.remove(s);
      return a;
   }
   
   public static ArrayList<Student> lastNameStartsWith(char c, ArrayList<Student> a) {
      ArrayList<Student> ret = new ArrayList<Student>();
      for (Student s : a) {
         if (s.getLastName().charAt(0) == c)
            ret.add(s);
      }
      return ret;
   }
   
   public static double getAverageGPA(ArrayList<Student> students) {
      double sum = 0;
      for (Student s : students)
         sum += s.getGpa();
      sum/=students.size();
      return sum;
   }
   
   public static void writeStudent(Student s, String fileRoute) {
      //Write the ID number? idk man
      PrintWriter pw;
      try {
         pw = new PrintWriter(new FileWriter(fileRoute, true));
      } catch (IOException e) {
         e.printStackTrace();
         return;
      }
      pw.println(s.getLastName());
      pw.println(s.getFirstName());
      pw.println(s.getGender());
      pw.println(s.getGpa());
      pw.println(s.getGradeLevel());
      pw.close();
   }
   
   @SuppressWarnings("resource")
   public static Student[] readFile(String fileRoute) {
      File f = new File(fileRoute);
      Scanner s = null;
      ArrayList<Student> students = new ArrayList<Student>();
      try {
         s = new Scanner(f);
      } catch (FileNotFoundException e) {
         System.out.println("not found");
         PrintWriter pw;
         try {
            pw = new PrintWriter(new FileWriter(fileRoute, false));
            pw.print("");
            return null;
         } catch (IOException e1) {
            e1.printStackTrace();
            return null;
         }
      }
      while(s.hasNextLine())
         students.add(readStudent(s));
      return students.toArray(new Student[students.size()]);
   }
   
   public static Student readStudent(Scanner s) {
      Student retStudent = new Student();
      try {
         retStudent.setLastName(s.nextLine());
         retStudent.setFirstName(s.nextLine());
         retStudent.setGender(s.nextLine());
         retStudent.setGpa(Double.parseDouble(s.nextLine()));
         retStudent.setGradeLevel(Integer.parseInt(s.nextLine()));
      } catch(NoSuchElementException e) {
         System.out.println("oi");
         e.printStackTrace();
      }
      return retStudent;
   }
   
   public static void main(String[] args) {
      Student[] students = StudentUtility.readFile(System.getProperty("user.home")+"/Downloads/studentData.txt");
      for (Student st : students)
         System.out.println(st);
   }
}
