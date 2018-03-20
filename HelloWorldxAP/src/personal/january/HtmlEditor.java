//Thomas Varano
//[Program Descripion]
//Jan 30, 2018

package personal.january;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public class HtmlEditor {
   public static void main(String[] args) {
      /*
       * Agenda is a schedule program for Pascack Hills (and possibly Valley)\n"
                     + "that can keep track of time, school schedules, assignments, and GPA\n"
                     + "for students.\n"
                     + "CREDITS:\n"
                     + "Thomas Varano : Author\n"
                     + "Viktor Nakev : Icon Designer\n"
                     + "Matthew Gheduzzi : Alpha Tester\n"
                     + "Michael Ruberto : Conceptual Designer",
       */
      String fr = "<html><iframe src=\"https://calendar.google.com/calendar/embed?src=8368c5a91jog3s32oc6k22f4e8%40"
            + "group.calendar.google.com&ctz=America%2FNew_York\" style=\"border: 0\" width=\"800\" "
            + "height=\"600\" frameborder=\"0\" scrolling=\"no\"></iframe></html>";
      String html = "<html> <h1> Agenda </h1> <h2>Version 1.7.1-beta</h2> <"
            + "p>Agenda is a schedule program for Pascack Hills (and possibly Valley)"
            + "<p>that can keep track of time, school schedules, assignments, and GPA"
            + "<p>for students."
            + "<br><br>"
            + "<h2>CREDITS:"
            + "<h3>Thomas Varano : Author"
            + "<br><br>Viktor Nakev : Icon Designer"
            + "<br><br>Matthew Ghedduzi : Alpha Tester"
            + "<br><br>Michael Ruberto : Conceptual Designer</html>";
      JEditorPane e = new JEditorPane("text/html", html);
      HTMLEditorKit kit = new HTMLEditorKit();
      e.setEditorKit(kit);
      StyleSheet sheet = kit.getStyleSheet();
      sheet.addRule("body {color:#000; font-family:Futura; margin: 4px; }");

      Document doc = kit.createDefaultDocument();
      e.setDocument(doc);
      e.setText(html);

      e.setOpaque(true);
//      e.setBackground(Color.LIGHT_GRAY.brighter());
      e.setEditable(false);
      JOptionPane.showMessageDialog(null, e, "title", JOptionPane.INFORMATION_MESSAGE, null);
   }
}
