//Thomas Varano
//[Program Descripion]
//Jan 29, 2018

package personal.january;

import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;

public class HtmlTest {
   public static void main(String[] args) {
      JEditorPane a = null;
      System.out.println("before");
         a = new JEditorPane("html", "<iframe src=\"https://calendar.google.com/calendar/embed?src=8368c5a91jog3s32oc6k22f4e8%40group.calendar.google.com&ctz=America%2FNew_York\" style=\"border: 0\" width=\"800\" height=\"600\" frameborder=\"0\" scrolling=\"no\"></iframe>");
      System.out.println("after");
      JFrame f = new JFrame();
      f.getContentPane().add(a);
      f.setVisible(true);
   }
}
