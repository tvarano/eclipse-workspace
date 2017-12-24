import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

//Thomas Varano
//[Program Descripion]
//Apr 20, 2017

public class Networking
{
   public static ServerSocket server;
   public static Socket socket;
   public static InetAddress ip;

   public static void main(String[] args) {
      String hostname;
      try {
          ip = InetAddress.getLocalHost();
          hostname = ip.getHostName();
          System.out.println("Your current IP address : " + ip);
          System.out.println("Your current Hostname : " + hostname);

      } catch (UnknownHostException e) {

          e.printStackTrace();
      }
      createServer();
  }
   public static void createServer(){
      try{
         server = new ServerSocket(4444);
      } catch (IOException e ){
         e.printStackTrace();
      }
   }
  

}
