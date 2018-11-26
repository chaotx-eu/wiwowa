package eu.zoho.chaotx.app;

import eu.zoho.chaotx.app.gui.dialog.WiWoWaDialog;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import java.io.File;

/**
 * Application for managing booking and user
 * data in its own projects
 * 
 * @Copyright Chaotx-EU
 */
public class App extends Application {
    public static final String APP_DIR
        = (System.getenv("APPDATA")
        + File.separator + ".wiwowa");

    public static void main(String[] args) {
        initApp();
        launch(args);
    }

    // Initialization logic required for the whole app
    public static void initApp() {
        File appDir = new File(APP_DIR);
        if(!appDir.exists()) appDir.mkdirs();
    }
    
    @Override
    public void start(Stage unused) {
        WiWoWaDialog wiwowa = new WiWoWaDialog(unused);
        wiwowa.showView();
    }
}
