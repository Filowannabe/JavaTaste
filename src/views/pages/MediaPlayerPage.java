package views.pages;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import javax.swing.SwingUtilities;

public class MediaPlayerPage extends JFXPanel {
    private JFXPanel panel;

    public MediaPlayerPage() {
        panel = this;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Parent root = null;
                try {
                    root = FXMLLoader
                            .load(getClass().getResource("../../MediaPlayer/MediaPlayer/src/mediaplayer/MediaPlayer.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);
                panel.setScene(scene);
            }
        });
    }

    public JFXPanel getPanel() {
        return this.panel;
    }

}
