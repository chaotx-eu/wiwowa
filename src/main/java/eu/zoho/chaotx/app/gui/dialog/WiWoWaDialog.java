package eu.zoho.chaotx.app.gui.dialog;

import javafx.stage.*;


public class WiWoWaDialog extends Stage{

   public WiWoWaDialog(Stage parent){
      initOwner(parent);
      initModality(Modality.WINDOW_MODAL);    
   }
}