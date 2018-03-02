//Thomas Varano
//Feb 8, 2018

package personal.january;

public class Logger {
   private boolean debug, log, error, trace, warn, info, usePrefix, stateClass;
   private Class<?> c;
   
   private Logger(Class<?> c) {
      this.c = c;
      setDebug(true); setLog(true); setError(true); setTrace(true); setWarn(true); setInfo(true); setUsePrefix(true);
      setStateClass(true);
   }
   
   private String prefix() {
      if (stateClass)
         return c.getCanonicalName() + " -- " + java.time.LocalTime.now() + " : ";
      return java.time.LocalTime.now() + " : ";
   }
   
   public static final String out = "out", err = "err";
   public static void setStream(String stream, java.io.PrintStream out) {
      if (stream.equals(Logger.out))
         System.setOut(out);
      if (stream.equals(Logger.err))
         System.setErr(out);
   }
   
   public void log(String s) {
      if (log)
         System.out.println(formatS(s));
   }
   
   public void debug(String s) {
      if (debug)
         System.out.println(formatS("DEBUG : " + s));
   }
   
   public void info(Object... o) {
      if (info)
         System.out.println(formatS(formatO(o)));
   }
   
   public void error(String s) {
      if (error) 
         System.err.println("ERROR : " + formatS(s));
   }
   
   public void error(String s, Throwable e) {
      if (error) {
         error(s + e.getMessage());
         e.printStackTrace();
      }
   }
   
   public void error(Throwable e) {
      if (error) {
         error(e.getMessage());
         e.printStackTrace();
      }
   }
   
   public void trace(Object... o) {
      if (trace) 
         System.out.println(formatS("TRACE : " + formatO(o)));
   } 
   
   public void warn(String s) {
      if (warn)
         System.err.println("WARNING : " + s);
   }
   
   private String formatS(String s) {
      return (usePrefix) ? prefix() + s : s;
   }
   
   private String formatO(Object... o) {
      String out = "";
      for (Object a : o) {
         out += a.toString() + ", ";
      }
      if (out.length() > 2)
         out.substring(0, out.length()-2);
      return out;
   }
   
   public void setDebug(boolean debug) {
      this.debug = debug;
   }
   public void setLog(boolean log) {
      this.log = log;
   }
   public void setError(boolean error) {
      this.error = error;
   }
   public void setTrace(boolean trace) {
      this.trace = trace;
   }
   public void setWarn(boolean warn) {
      this.warn = warn;
   }
   public void setInfo(boolean info) {
      this.info = info;
   }
   public void setUsePrefix(boolean usePrefix) {
      this.usePrefix = usePrefix;
   }
   public void setStateClass(boolean state) {
      stateClass = state;
   }
   
   public static Logger getLogger(Class<?> caller) {
      return new Logger(caller);
   }
}
