//Thomas Varano
//[Program Descripion]
//Jan 22, 2018

package personal.january;

import java.awt.Desktop;
import java.awt.desktop.UserSessionEvent;
import java.awt.desktop.UserSessionListener;

public class DesktopExplo {
   public static void main(String[] args) {
      Desktop.getDesktop().openHelpViewer();
      Desktop.getDesktop().addAppEventListener(new UserSessionListener() {

         @Override
         public void userSessionActivated(UserSessionEvent arg0) {
         }
         @Override
         public void userSessionDeactivated(UserSessionEvent arg0) {
         }
      });
   }
}
