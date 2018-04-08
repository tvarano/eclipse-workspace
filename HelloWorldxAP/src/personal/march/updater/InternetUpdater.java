//Thomas Varano
//Mar 22, 2018

package personal.march.updater;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class InternetUpdater {
   public static final String VERSION = "1.7.7";
   public static final String SOURCE_PATH = "http://agendapascack.x10host.com/updates/updater-src.txt";
   public static final String DOWNLOAD_PATH = System.getProperty("user.home") + "/Downloads/Agenda-" + VERSION + "-Update.jar";
   
   public static void main(String[] args) {
      try {
         URL sourceURL = new URL(SOURCE_PATH);
         File download = new File(DOWNLOAD_PATH);
         copyFileUsingStream(sourceURL.openStream(), download);
         Process run = new ProcessBuilder("java", "-jar", DOWNLOAD_PATH).start();
         InputStream in = run.getInputStream();
         byte[] bts = in.readAllBytes();
         for (byte b : bts)
            System.out.print((char)b);
         System.out.println("run: " + run.waitFor());
         
      } catch (IOException | InterruptedException e) {
         e.printStackTrace();
      }
   }
   
   private static void copyFileUsingStream(InputStream source, File dest) throws IOException {
      OutputStream os = null;
      System.out.println("copying from: " + source);
      System.out.println("to: " + dest);
      try {
          os = new FileOutputStream(dest);
          byte[] buffer = new byte[1024];
          int length;
          while ((length = source.read(buffer)) > 0) {
              os.write(buffer, 0, length);
          }
      } finally {
          source.close();
          os.close();
      }
   }
}
