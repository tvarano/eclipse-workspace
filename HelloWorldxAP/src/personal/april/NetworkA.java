//Thomas Varano
//Apr 16, 2018

package personal.april;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NetworkA {
   public static void main(String[] args) throws Exception {
      a();
//      System.exit(0);
   }
   
   public static void a() throws Exception {
      InetAddress localhost = InetAddress.getLocalHost();
      byte[] ip = localhost.getAddress();
      for (int i = 1; i < 255; i++) {
          ip[3] = (byte)i;
          InetAddress address = InetAddress.getByAddress(ip);
//          if (address.isReachable(10000))
          if (address.isSiteLocalAddress()) {
              System.out.println(address + address.getHostAddress() + address.getAddress() + address.getHostName()+ address.getCanonicalHostName());
              System.out.println("name: "+address.getHostName());
          }
      }
   }
   
   public static void b() {
      String macAdress = "5caafd1b0019";
      String dataUrl = "http://api.macvendors.com/" + macAdress;
      HttpURLConnection connection = null;
      try {
          URL url = new URL(dataUrl);
          connection = (HttpURLConnection) url.openConnection();
          connection.setRequestMethod("POST");
          connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
          connection.setDoInput(true);
          connection.setDoOutput(true);
          DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
          wr.flush();
          wr.close();
          InputStream is = connection.getInputStream();
          BufferedReader rd = new BufferedReader(new InputStreamReader(is));
          StringBuffer response = new StringBuffer();
          String line;
          while ((line = rd.readLine()) != null) {response.append(line);response.append('\r');}
          rd.close();
          String responseStr = response.toString();
          System.out.println("Server response: " + responseStr);
      } catch (Exception e) {e.printStackTrace();} finally {if (connection != null) {connection.disconnect();}}
   }
   
   
   public static void c() {
      try {
         Enumeration nis = NetworkInterface.getNetworkInterfaces();
         while (nis.hasMoreElements()) {
            NetworkInterface ni = (NetworkInterface) nis.nextElement();
            Enumeration ias = ni.getInetAddresses();
            while (ias.hasMoreElements()) {
               InetAddress ia = (InetAddress) ias.nextElement();
               System.out.println(ia.getHostName());
            }

         }
      } catch (SocketException ex) {
         Logger.getLogger(NetworkA.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
}
