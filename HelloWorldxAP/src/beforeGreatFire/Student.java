package beforeGreatFire;

//Thomas Varano
//[Program Descripion]
//Oct 17, 2017

//name, grade, gpa, ID number (assigned, static), equals, compareTo last name alphabet
public class Student implements Comparable<Student>
{
   private String firstName, lastName, gender;
   private double gpa;
   private int gradeLevel, IDNumber;
   private static int IDAbsolute = 800000;
   
   public Student(String firstName, String lastName, String gender, int gradeLevel, double gpa) {
      setFirstName(firstName); setLastName(lastName); setGender(gender); setGradeLevel(gradeLevel); setGpa(gpa);
      setIDNumber(IDAbsolute);
      IDAbsolute++;
   }
   public Student() {
      this("firstName", "lastName", "O", 0, 0.0);
   }
   
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   public String getLastName() {
      return lastName;
   }
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
   public double getGpa() {
      return gpa;
   }
   public void setGpa(double gpa) {
      this.gpa = gpa;
   }
   public static int getIDAbsolute() {
      return IDAbsolute;
   }  
   public int getIDNumber() {
      return IDNumber;
   }
   public String getFirstName() {
      return firstName;
   }
   private void setIDNumber(int x) {
      IDNumber = x;
   }
   public String getGender() {
      return gender;
   }
   public void setGender(String gender) {
      this.gender = gender;
   }
   public int getGradeLevel() {
      return gradeLevel;
   }
   public void setGradeLevel(int gradeLevel) {
      this.gradeLevel = gradeLevel;
   }
   @Override
   public int compareTo(Student o) {
      if (o == null) return lastName.length();
      if (lastName.compareTo(o.lastName) != 0)
         return lastName.compareTo(o.lastName);
      return firstName.compareTo(o.firstName);
   }
   public boolean equals(Student o) {
      if (o == null) return false;
      return (IDNumber == o.getIDNumber() && firstName.equals(o.firstName) && lastName.equals(o.lastName));
   }
   
   @Override
   public String toString() {
      return getClass().getName()+"[firstName=" + firstName + ", lastName=" + lastName
            + ", gender=" + gender + ", gpa=" + gpa + ", gradeLevel="
            + gradeLevel + ", IDNumber=" + IDNumber + "]";
   }
   public static void main(String[] args) {
      
   }
}
