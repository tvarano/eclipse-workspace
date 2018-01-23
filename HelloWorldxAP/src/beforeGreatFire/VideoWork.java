package beforeGreatFire;
import javax.swing.JPanel;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
//Thomas Varano
//[Program Descripion]
//Nov 5, 2017

public class VideoWork extends Application {

   @Override
   public void start(Stage primaryStage) {
      // Add a scene
      Group root = new Group();
      Scene scene = new Scene(root, 500, 200);

      Media pick = new Media("kelpyGLoopable.wav");
      MediaPlayer player = new MediaPlayer(pick);
      player.play();

      // Add a mediaView, to display the media. Its necessary !
      // This mediaView is added to a Pane
      MediaView mediaView = new MediaView(player);
      ((Group) scene.getRoot()).getChildren().add(mediaView);

      // show the stage
      primaryStage.setTitle("Media Player");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
   public static void main(String[] args) {
      VideoWork.launch(args);
   }
}
