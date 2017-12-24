//Thomas Varano
//[Program Descripion]
//Mar 18, 2017

public class Command
{
   private String label, stringParam;
   private long millisTiming, startTime;
   private double parameterOne, parameterTwo;
   private boolean done;
   
   public Command(String label, double parameterOne, double parameterTwo, long millisTiming){
      this.label = label;
      this.parameterOne = parameterOne;
      this.parameterTwo = parameterTwo;
      this.millisTiming = millisTiming;
      setStartTime(System.currentTimeMillis());
   }
   public Command(String label, double parameterOne, long millisTiming){
      this(label,parameterOne,-1,millisTiming);
   }
   public Command(String label, long millisTiming){
      this(label,-1,millisTiming);
   }
   public Command(String label, double parameterOne, double parameterTwo){
      this(label,parameterOne,parameterTwo,0);
   }
   public Command(String label){
      this(label,0);
   }
   public Command(String label, String stringParam){
      this(label,-1,-1,0);
      this.setStringParam(stringParam);
      done = true;
   }
   
   public String toString(){
      if (parameterOne!=-1 || parameterTwo!=-1)
         return this.getClass().getName()+"["+label+"("+parameterOne+","+parameterTwo+") timing= "+millisTiming+"]";
      else{
         return this.getClass().getName()+"["+label+"("+stringParam+")]";
      }
   }
   
   public String getLabel() {
      return label;
   }

   public void setLabel(String label) {
      this.label = label;
   }

   public long getMillisTiming() {
      return millisTiming;
   }

   public void setMillisTiming(long millisTiming) {
      this.millisTiming = millisTiming;
   }

   public double getParameterOne() {
      return parameterOne;
   }

   public void setParameterOne(double parameterOne) {
      this.parameterOne = parameterOne;
   }

   public double getParameterTwo() {
      return parameterTwo;
   }

   public void setParameterTwo(double parameterTwo) {
      this.parameterTwo = parameterTwo;
   }

   public long getStartTime() {
      return startTime;
   }

   public void setStartTime(long startTime) {
      this.startTime = startTime;
   }
   public boolean isDoneTime() {
      return System.currentTimeMillis()>=startTime+millisTiming;
   }
   public boolean isDoneSwitch(){
      return done;
   }
   public void setDone(boolean done) {
      this.done = done;
   }

   public String getStringParam() {
      return stringParam;
   }

   public void setStringParam(String stringParam) {
      this.stringParam = stringParam;
   }
}
