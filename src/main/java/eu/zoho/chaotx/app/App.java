package eu.zoho.chaotx.app;

import eu.zoho.chaotx.app.gui.dialog.WiWoWaDialog;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Application for managing and booking and user
 * data in its own projects
 * 
 * @Copyright Chaotx-EU
 */
public class App extends Application {
    
    public static void main(String[] args) {
        launch(args);
        System.out.println("Hello World");
    }

    @Override
    public void start(Stage unused) {
        WiWoWaDialog wiwowa = new WiWoWaDialog(unused);
        wiwowa.showView();
    }
}
