
public class SendMailSSL {
   public static void main(String[] args) {
      // from,password,to,subject,message
      
      //pascackagendamailer@gmail.com
      //AlphaOmega123
      GmailHandler.send("pascackagendamailer@gmail.com", "AlphaOmega123", "pascackagendamailer@gmail.com", "Agenda Test",
            "hey jer?");
      // change from, password and to
   }
}