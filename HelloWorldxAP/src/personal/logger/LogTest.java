//Thomas Varano
//May 22, 2018

package personal.logger;

import java.util.logging.Level;
import java.util.logging.LogRecord;

public class LogTest {
   public static void main(String[] args) {
      BasicLogger l = BasicLogger.getLogger("abcd");
      l.log(new LogRecord(Level.CONFIG, "oi"));
      l.log(new LogRecord(Level.ALL, "albS"));
   }
}
