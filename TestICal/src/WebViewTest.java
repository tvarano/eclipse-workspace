import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebViewTest {

    /* Create a JFrame with a JButton and a JFXPanel containing the WebView. */
    private static void initAndShowGUI() {
        // This method is invoked on Swing thread
        JFrame frame = new JFrame("FX");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(null); // do the layout manually

//        final JButton jButton = new JButton("Button");
        final JTextField jField = new JTextField();
        
        final JFXPanel fxPanel = new JFXPanel();

        frame.add(jField);
        frame.add(fxPanel);
        frame.setVisible(true);

        jField.setSize(new Dimension(200, 27));
        fxPanel.setSize(new Dimension(1000, 1000));
        fxPanel.setLocation(new Point(0, 27));

        frame.getContentPane().setPreferredSize(new Dimension(300, 327));
        frame.pack();
//        frame.setResizable(false);
        Platform.runLater(new Runnable() { // this will run initFX as JavaFX-Thread
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });
    }

    /* Creates a WebView and fires up google.com */
    private static void initFX(final JFXPanel fxPanel) {
        Group group = new Group();
        Scene scene = new Scene(group);
        fxPanel.setScene(scene);

        WebView webView = new WebView();

        group.getChildren().add(webView);
        webView.setMinSize(300, 300);
        webView.setMaxSize(1600, 1000);

        System.out.println("gooo");
        webView.setVisible(true);
            // Obtain the webEngine to navigate
        WebEngine webEngine = webView.getEngine();
        webEngine.load("http://www.google.com/");
    }

    /* Start application */
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowGUI();
            }
        });
    }
}