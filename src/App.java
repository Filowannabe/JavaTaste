//███████╗██╗██╗      ██████╗ 
//██╔════╝██║██║     ██╔═══██╗
//█████╗  ██║██║     ██║   ██║
//██╔══╝  ██║██║     ██║   ██║
//██║     ██║███████╗╚██████╔╝
//╚═╝     ╚═╝╚══════╝ ╚═════╝ 
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import Navigator.Navigator;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {
    private static Navigator navigator;

    public static void main(String[] args) throws Exception {
        int chooser = 0;
        if (chooser == 0) {
            launch(args);
        } else {
            navigator = new Navigator();
            navigator.goHelloPage(0, 0, navigator.getBodyWidth(), navigator.getBodyHeight());
            navigator.initComponents();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Navigator navigator = new Navigator();
        JFXPanel fxPanel = new JFXPanel();
        navigator.goMediaPlayerPage(fxPanel, navigator.getBodyWidth(), navigator.getBodyHeight() - 50);
        navigator.initComponents();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root = null;
                try {
                    root = FXMLLoader
                            .load(getClass().getResource("MediaPlayer/MediaPlayer/src/mediaplayer/MediaPlayer.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);
                fxPanel.setScene(scene);
            }
        });
    }
}
