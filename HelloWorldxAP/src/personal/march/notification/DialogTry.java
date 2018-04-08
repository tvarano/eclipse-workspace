package personal.march.notification;

import java.awt.Dialog.ModalityType;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class DialogTry {
  public static void main(String[] args) {

    JDialog nonModalDialog = new JDialog(null, "Non-Modal Dialog",
        ModalityType.MODELESS);
    nonModalDialog.add(Box.createRigidArea(new Dimension(200, 200)));
    nonModalDialog.pack();
    nonModalDialog.setVisible(true);
    nonModalDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    
    try {
      Thread.sleep(1000);
   } catch (InterruptedException e) {
      e.printStackTrace();
   }
    JDialog modalDialog = new JDialog(null, "Modal Dialog",
        ModalityType.APPLICATION_MODAL);
//    modalDialog.add(Box.createRigidArea(new Dimension(200, 200)));
    modalDialog.pack();
    modalDialog.setVisible(true);
    modalDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    try {
       Thread.sleep(1000);
    } catch (InterruptedException e) {
       e.printStackTrace();
    }
    new JFrame("Hello").setVisible(true);
  }
}