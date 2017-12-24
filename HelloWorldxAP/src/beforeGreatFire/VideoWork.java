package beforeGreatFire;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
//Thomas Varano
//[Program Descripion]
//Nov 5, 2017

public class VideoWork extends JPanel
{
   public VideoWork() {
   }
   
   
   private static void createAndShowGUI() {
      JFrame f = new JFrame("Lets try video");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.getContentPane().add(new VideoWork());
      f.pack();
      f.setLocationRelativeTo(null);
      f.setVisible(true);   
   }
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }

   public class MediaControl extends BorderPane {
      private MediaPlayer mp;
      private MediaView mediaView;
      private final boolean repeat = false;
      private boolean stopRequested = false;
      private boolean atEndOfMedia = false;
      private Duration duration;
      private Slider timeSlider;
      private Label playTime;
      private Slider volumeSlider;
      private HBox mediaBar;

      public MediaControl(final MediaPlayer mp) {
          this.mp = mp;
          setStyle("-fx-background-color: #bfc2c7;");
          mediaView = new MediaView(mp);
          Pane mvPane = new Pane() {                };
          mvPane.getChildren().add(mediaView);
          mvPane.setStyle("-fx-background-color: black;"); 
          setCenter(mvPane);
       }
  }
}
