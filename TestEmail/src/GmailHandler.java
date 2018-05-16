import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class GmailHandler {
   private static boolean debug = true;
   
   public static void send(String from, String password, String to, String sub,
         String msg) {
      // Get properties object
      String port = "465";
      Properties props = new Properties();
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.socketFactory.port", port);
      props.put("mail.smtp.socketFactory.class",
            "javax.net.ssl.SSLSocketFactory");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.port", port);
      props.put("mail.smtp.timeout", "10000");    
      props.put("mail.smtp.connectiontimeout", "10000");    
      // get Session
      Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                  return new PasswordAuthentication(from, password);
               }
            });
      // compose message
      long start = 0;
      try {
         session.getTransport("smtp").addConnectionListener(new ConnectionListener() {
            @Override
            public void closed(ConnectionEvent arg0) {
               System.out.println("close" + arg0.getSource()); 
            }
            @Override
            public void disconnected(ConnectionEvent arg0) {
               System.out.println("disc" + arg0.getSource()); 
            }

            @Override
            public void opened(ConnectionEvent arg0) {
               System.out.println("open" + arg0.getSource()); 
            }
            
         });
         System.out.println("IT IS GOOD");
      } catch (MessagingException e1) {
         e1.printStackTrace();
      }
      try {
         MimeMessage message = new MimeMessage(session);
         message.addRecipient(Message.RecipientType.TO,
               new InternetAddress(to));
         message.setSubject(sub);
         message.setText(msg);
         // send message
         start = System.currentTimeMillis();
         if (debug) System.out.println("send begun");
         Transport.send(message);
         if (debug) System.out.println("message sent successfully");
         if (debug) System.out.println("send took " + (System.currentTimeMillis() - start));
         JOptionPane.showMessageDialog(null, "message sent");
      } catch (MessagingException e) {
         if (debug) System.out.println("send failed in " + (System.currentTimeMillis() - start));
         JOptionPane.showMessageDialog(null, "failure");
         throw new RuntimeException(e);
      }
   }
   
   private static MimeMessage getMessage(Session session, String to, String sub, String msg) throws MessagingException {
      MimeMessage message = new MimeMessage(session);
      message.addRecipient(Message.RecipientType.TO,
            new InternetAddress(to));
      message.setSubject(sub);
      message.setText(msg);
      return message;
   }
   
   private static Session getAuth(Properties props, String from, String password) {
      return Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                  return new PasswordAuthentication(from, password);
               }
            });
   }
   
   private static Properties getProps(String type) {
      Properties props = new Properties();
      props.put("mail." + type + ".host", type+".gmail.com");
      props.put("mail." + type + ".socketFactory.port", "465");
      props.put("mail." + type + ".socketFactory.class",
            "javax.net.ssl.SSLSocketFactory");
      props.put("mail." + type + ".auth", "true");
      props.put("mail." + type + ".port", "465");
      props.put("mail." + type + ".timeout", "10000");    
      props.put("mail." + type + ".connectiontimeout", "10000");
      return props;
   }
   
   protected static boolean sendMessage(MimeMessage msg) {
      try {
         final long start = System.currentTimeMillis();
         Transport.send(msg);
         if (debug) System.out.println("message sent successfully");
         if (debug) System.out.println("send took " + (System.currentTimeMillis() - start));
         return true;
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
   
   public static void sendSMTP(String from, String password, String to, String sub,
         String msg) {
      // Get properties object
     Properties props = getProps("smtp");
      // get Session
      Session session = getAuth(props, from, password);
      // compose message
      try {
         sendMessage(getMessage(session, to, sub, msg));
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
   
   public static void sendPOP(String from, String password, String to, String sub, String msg) {
      Properties props = getProps("pop"); 
      
      Session auth = getAuth(props, from, password);
      
      try {
         sendMessage(getMessage(auth, to, sub, msg));
      } catch (MessagingException e) {
         e.printStackTrace();
      }
   }
   
   public static void sendIMAP(String from, String password, String to, String sub, String msg) {
      Properties props = getProps("imap"); 
      
      Session auth = getAuth(props, from, password);
      try {
         sendMessage(getMessage(auth, to, sub, msg));
      } catch (MessagingException e) {
         e.printStackTrace();
      }
   }
   
   public static void main(String[] args) {
      send("pascackagendamailer@gmail.com", "AlphaOmega123", "pascackagendamailer@gmail.com", "Agenda Test",
            "private server config");
   }
}