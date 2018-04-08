//Thomas Varano
//Mar 22, 2018

package personal.march.updater;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class JarCopy {
   static String home = System.getProperty("user.home");
   public static void main(String[] args) {
      //use user.dir for location and then add the jar name
      /*
      try {
         transfer("/Users/varanoth/Desktop/JarTest.txt");
      } catch (IOException e) {
         e.printStackTrace();
      }
      
      try {
         copyFileUsingStream(new URL("http://agendapascack.x10host.com/updates/JarTest.txt").openStream(), new File("/Users/varanoth/Desktop/downloadJar.jar"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      
//      try {
//         copyFileToURL(Updater.class.getResourceAsStream("src.jar"), new URL("http://agendapascack.x10host.com/updates/sourcecode.txt"));
//      } catch (MalformedURLException e1) {
//         e1.printStackTrace();
//      } 
       */
      copyUpdaterJarToText();
   }
   
   private static void copyUpdaterJarToText() {      
      try {
         fileToFileUsingStream(new File(home + "/Desktop/Update/Updater.jar"), new File(home + "/Desktop/Update/UpdaterText.txt"));
      } catch (IOException e) {
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
   
   private static void copyFileToURL(InputStream source, URL dest) {
      OutputStream os = null;
      System.out.println("copying from: " + source);
      System.out.println("to: " + dest);
      try {
         os = dest.openConnection().getOutputStream();
         byte[] buffer = new byte[1024];
         int length;
         while ((length = source.read(buffer)) > 0) {
            os.write(buffer, 0, length);
         }
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         try {
            source.close();
            os.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      
   }
   
   private static void fileToFileUsingStream(File source, File dest) throws IOException {
      copyFileUsingStream(new FileInputStream(source), dest);
   }
   private static void transfer(String dest) throws IOException {
      copyFileUsingStream(JarCopy.class.getResourceAsStream("src.jar"), new File(dest));
   }
}
