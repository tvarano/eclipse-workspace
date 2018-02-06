//Thomas Varano
//[Program Descripion]
//Jan 15, 2018

package personal.january;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
 
//SplitPaneDemo itself is not a visible component.
public class SplitPaneDemo extends JPanel
                          implements ListSelectionListener {
    private JLabel picture;
    private JList<String> list;
    private JSplitPane splitPane;
    private String[] imageNames = { "Bird", "Cat", "Dog", "Rabbit", "Pig", "dukeWaveRed",
        "kathyCosmo", "lainesTongue", "left", "middle", "right", "stickerface"};
    public SplitPaneDemo() {
 
        //Create the list of images and put it in a scroll pane.
         
        list = new JList<String>(imageNames);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
         
        
        JScrollPane listScrollPane = new JScrollPane(list);
        picture = new JLabel();
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.CENTER);
         
        JScrollPane pictureScrollPane = new JScrollPane(picture);
 
        //Create a split pane with the two scroll panes in it.
        Border border = new LineBorder(Color.green, 5);
        UIManager.put("SplitPaneDivider.border", border);
        UIManager.put("SplitPane.dividerSize", 2);
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                   listScrollPane, pictureScrollPane);
        for (Component c : splitPane.getComponents())
           System.out.println(c);
        BasicSplitPaneDivider div = (BasicSplitPaneDivider) splitPane.getComponent(2);
        div.setBackground(Color.GREEN);

        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);
 
        //Provide minimum sizes for the two components in the split pane.
        Dimension minimumSize = new Dimension(100, 50);
        listScrollPane.setMinimumSize(minimumSize);
        pictureScrollPane.setMinimumSize(minimumSize);
 
        //Provide a preferred size for the split pane.
        splitPane.setPreferredSize(new Dimension(400, 200));
        updateLabel(imageNames[list.getSelectedIndex()]);
    }
     
    //Listens to the list
    public void valueChanged(ListSelectionEvent e) {
        @SuppressWarnings("unchecked")
      JList<String> list = (JList<String>)e.getSource();
        updateLabel(imageNames[list.getSelectedIndex()]);
    }
     
    //Renders the selected image
    protected void updateLabel (String name) {
        ImageIcon icon = createImageIcon("images/" + name + ".gif");
        picture.setIcon(icon);
        if  (icon != null) {
            picture.setText(null);
        } else {
            picture.setText("Image not found");
        }
    }
 
    //Used by SplitPaneDemo2
    public JList<String> getImageList() {
        return list;
    }
 
    public JSplitPane getSplitPane() {
        return splitPane;
    }
 
    
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
       java.net.URL imgURL = SplitPaneDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
 
        //Create and set up the window.
        JFrame frame = new JFrame("SplitPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SplitPaneDemo splitPaneDemo = new SplitPaneDemo();
        frame.getContentPane().add(splitPaneDemo.getSplitPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
 
       
}
