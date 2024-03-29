package constants;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

import managers.Main;

//Thomas Varano
//[Program Descripion]
//Oct 24, 2017

public enum ErrorID {
   SCHEDULE_NULL(), 
   FILE_TAMPER(
         "There was an error with reading your schedule.\n"
               + "It has been reset to the default",
         false), INPUT_ERROR(
               "Input Error. Make sure all fields are filled correctly",
               true), 
   OTHER();

   public static final String ERROR_NAME = Main.APP_NAME + " ERROR";
   private final String ID;
   private final String message;
   private final boolean userError;

   private ErrorID(String message, boolean userError) {
      this.ID = Integer.toHexString((this.ordinal() + 1) * 10000);
      this.message = message;
      this.userError = userError;
   }

   private ErrorID() {
      this("Internal Error", false);
   }

   public String getID() {
      return ID;
   }

   public static void showInternalError(ErrorID error, boolean recover) {
      int choice = JOptionPane.showOptionDialog(null,
            "An error has occurred.\nClick \"Info\" for more information.",
            ERROR_NAME, JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,
            null, new String[]{"Info", "Close"}, "Close");
      if (choice == 0)
         JOptionPane.showMessageDialog(null,
               "Details:\n" + error.message + "\nErrorID: " + error.getID(),
               ERROR_NAME, JOptionPane.ERROR_MESSAGE);

      if (!recover)
         System.exit(0);
   }

   public static void showUserError(ErrorID error, boolean recover) {
      Toolkit.getDefaultToolkit().beep();
      int choice = JOptionPane.showOptionDialog(null,
            "An input error occurred. Try again.", ERROR_NAME,
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
            new String[]{"Info", "Close"}, "Close");
      if (choice == 0)
         JOptionPane.showMessageDialog(null,
               "Details:\n" + error.message + "\nErrorID: " + error.getID(),
               ERROR_NAME, JOptionPane.WARNING_MESSAGE);

      if (!recover)
         System.exit(0);
   }

   public static void showError(ErrorID error, boolean recover) {
      if (error.userError)
         showUserError(error, recover);
      else
         showInternalError(error, recover);
   }
   // 2ae35
   public static ErrorID getError(String ID) {
      for (ErrorID e : values())
         if (e.getID().equals(ID))
            return e;
      return null;
   }

   public static void main(String[] args) {
      System.out.println(getError("7530"));
   }
}
