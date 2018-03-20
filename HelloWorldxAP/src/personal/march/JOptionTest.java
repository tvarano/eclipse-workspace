//Thomas Varano
//Mar 15, 2018

package personal.march;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;

public class JOptionTest {
   public static void main(String[] args) {
      Font font = new Font("Futura", Font.PLAIN, 16);
      String html = "<html> <h1> Welcome to Agenda</h1>"
            + "<h2>Version 1.7.6.1</h2> "
            + "<p>***Program is still in beta. Please report all errors / bugs by emailing me the log"
            + "<br>at ehehe"
            + "<br>email log or any ideas to varanoth@pascack.org***"
            + "<br>You can use this program to keep track of classes, schedules, assignments, or grades"
            + "<br>in Pascack Hills or Valley."
            + "<ul>"
            + "<li>On the home screen, you can see the current class's data "
            + "<br>on the top panel and view other classes' data and memos in the bottom panel</li>"
            + "<li>To edit your classes, click File > Input Schedule.</li>"
            + "<li>To edit grades, click File > View GPA.</li>"
            + "<li>To change the look of the program, either go to preferences (\u2318 + ,) or the View Menu"
            + "</ul>"
            + "<p>Feel free to look at the source code (Useful Links > Agenda Source) to suggest any improvements."
            + "<br> - Thomas Varano"
            + "</html>";
      javax.swing.JEditorPane content = new javax.swing.JEditorPane("text/html", html);
      content.setFont(font);
      HTMLEditorKit kit = new HTMLEditorKit();
      content.setEditorKit(kit);
      kit.getStyleSheet().addRule("body {color:#000; font-family:"
            + font.getFamily() + "; margin: 4px; }");

      Document doc = kit.createDefaultDocument();
      content.setDocument(doc);
      content.setText(html);
      content.setOpaque(false);
      JOptionPane.showMessageDialog(null, content, "Welcome",
            JOptionPane.INFORMATION_MESSAGE,
            null);
   }
}
