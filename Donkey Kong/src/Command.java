//Thomas Varano
//[Program Descripion]
//Mar 18, 2017

public class Command
{
   private String label, stringParam;
   private long ticksTiming, startTime, ticks;
   private double parameterOne, parameterTwo;
   private boolean done;
   
   public Command(String label, double parameterOne, double parameterTwo, long ticksTiming){
      this.label = label;
      this.parameterOne = parameterOne;
      this.parameterTwo = parameterTwo;
      this.ticksTiming = ticksTiming;
      setStartTime(System.currentTimeMillis());
      done = false;
   }
   public Command(String label, double parameterOne, long millisTiming){
      this(label,parameterOne,-1,millisTiming);
   }
   public Command(String label, long millisTiming){
      this(label,-1,millisTiming);
   }
   public Command(String label, double parameterOne, double parameterTwo){
      this(label,parameterOne,parameterTwo,1);
   }
   public Command(String label){
      this(label,1);
   }
   public Command(String label, String stringParam){
      this(label,-1,-1,1);
      this.setStringParam(stringParam);
   }
   
   public String toString(){
      if (parameterOne!=-1 || parameterTwo!=-1)
         return this.getClass().getName()+"["+label+"("+parameterOne+","+parameterTwo+") timing= "+ticksTiming+
               ", done= "+(isDoneTicks()||isDoneSwitch())+"]";
      else{
         return this.getClass().getName()+"["+label+"("+stringParam+") done= "+(isDoneTicks()||isDoneSwitch())+"]";
      }
   }
   
   public String getLabel() {
      return label;
   }

   public void setLabel(String label) {
      this.label = label;
   }

   public long getMillisTiming() {
      return ticksTiming;
   }

   public void setMillisTiming(long millisTiming) {
      this.ticksTiming = millisTiming;
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
   public boolean isDoneTicks() {
      return (ticks>=ticksTiming);
   }
   public boolean isDoneSwitch(){
      return done;
   }
   public boolean isDone(){
      return (isDoneTicks()||isDoneSwitch());
   }
   public void addTick(){
      ticks++;
   }
   public long getTicks(){
      return ticks;
   }
   public void setTicks(long ticks){
      this.ticks = ticks;
   }
   public void resetTicks(){
      ticks = 0;
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
