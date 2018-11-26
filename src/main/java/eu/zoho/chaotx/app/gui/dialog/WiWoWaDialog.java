package eu.zoho.chaotx.app.gui.dialog;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;




public class WiWoWaDialog extends Stage{

   public WiWoWaDialog(Stage parent){
      initOwner(parent);
      initModality(Modality.WINDOW_MODAL);
      //BorderPane anlegen
      BorderPane bp = new BorderPane();
      //VBox Links anlegen(lbLinksKi = LabelLinksKundeninfo, lbRechtsKi = LabelRechtsKundeninfo)
      VBox vb_lbLinksKi = new VBox();
      vb_lbLinksKi.setPadding(new Insets(10,10,10,10));

      VBox vb_tfLinksKi = new VBox();
      vb_tfLinksKi.setPadding(new Insets(10,10,10,10));

      //VBox Rechts anlegen(lbRechtsKi = LabelRechtsKundeninfo, tfRechtsKi = TextFieldRechtsKundeninfo)
      VBox vb_lbRechtsKi = new VBox();
      vb_lbRechtsKi.setPadding(new Insets(10,10,10,10));

      VBox vb_tfRechtsKi = new VBox();
      vb_tfRechtsKi.setPadding(new Insets(10,10,10,10));

      //Listen für die zwei VBoxen Links erstellt
      List<Label> lbli_List = new ArrayList<>();
      List<TextField> tfli_List = new ArrayList<>();

      //Listen für die zwei VBoxen rechts erstellt
      List<Label> lbre_List = new ArrayList<>();
      List<TextField> tfre_List = new ArrayList<>();
      
     
      //Label Kundeninfo Links (Abkürzung: lb = Label, li = Links)
      lbli_List.add(new Label("Vorname"));
      lbli_List.add(new Label("Name"));
      lbli_List.add(new Label("Strasse"));
      lbli_List.add(new Label("PLZ"));
      lbli_List.add(new Label("Ort"));
      lbli_List.add(new Label("Land"));
      lbli_List.add(new Label("Telefon"));
      lbli_List.add(new Label("Handy"));
      lbli_List.add(new Label("E-mail"));
      lbli_List.add(new Label("Homepage"));
      lbli_List.add(new Label("Fax"));

      //Label Kundeninfo Rechts(Abkürzung: lb = Label, re = Rechts)
      lbre_List.add(new Label("Wohnwagen"));
      lbre_List.add(new Label("Reisedatum"));
      lbre_List.add(new Label("Reiseziel"));
      lbre_List.add(new Label("Personenzahl"));
      lbre_List.add(new Label("Kinder/Alter"));
      lbre_List.add(new Label("Haustier"));
      lbre_List.add(new Label("Führerschein"));
      lbre_List.add(new Label("Auto"));
      lbre_List.add(new Label("Übergabe"));
      lbre_List.add(new Label("Rückgabe"));
      


      //Textfield Kundeninfo Links (Abkürzung: tf = TextField, li = Links)
      tfli_List.add(new TextField());
      tfli_List.add(new TextField());
      tfli_List.add(new TextField());
      tfli_List.add(new TextField());
      tfli_List.add(new TextField());
      tfli_List.add(new TextField());
      tfli_List.add(new TextField());
      tfli_List.add(new TextField());
      tfli_List.add(new TextField());
      tfli_List.add(new TextField());
      tfli_List.add(new TextField());

      //Textfield Kundeninfo Rechts(Abkürzung: tf = TextField, re = rechts)
      tfre_List.add(new TextField());
      tfre_List.add(new TextField());
      tfre_List.add(new TextField());
      tfre_List.add(new TextField());
      tfre_List.add(new TextField());
      tfre_List.add(new TextField());
      tfre_List.add(new TextField());
      tfre_List.add(new TextField());
      tfre_List.add(new TextField());
      tfre_List.add(new TextField());
      

      for(int i = 0; i < lbli_List.size(); i++){
         lbli_List.get(i).prefHeightProperty().bind(tfli_List.get(i).heightProperty());
         vb_lbLinksKi.getChildren().add(lbli_List.get(i));
         vb_tfLinksKi.getChildren().add(tfli_List.get(i));
      }

      for(int i = 0; i < lbre_List.size(); i++){
         lbre_List.get(i).prefHeightProperty().bind(tfre_List.get(i).heightProperty());
         vb_lbRechtsKi.getChildren().add(lbre_List.get(i));
         vb_tfRechtsKi.getChildren().add(tfre_List.get(i));
      }

      HBox hb = new HBox(vb_lbLinksKi,vb_tfLinksKi,vb_lbRechtsKi,vb_tfRechtsKi);
      //VBox für die Überschrift "Kundeninfo"
      VBox vb_Body = new VBox();
      Label lb_Body = new Label("Kundeninfo");
      Separator sep_left = new Separator();
      Separator sep_right = new Separator();
      HBox.setHgrow(sep_left, Priority.SOMETIMES);
      HBox.setHgrow(sep_right, Priority.SOMETIMES);
      HBox hbx_label = new HBox(sep_left, lb_Body, sep_right);
      
      vb_Body.getChildren().addAll(hbx_label, hb);

      //die Linken und Rechten VBoxen der BorderPane hinzufügen      
      bp.setTop(vb_Body);

      setTitle("Neuer Kunde");
      setScene(new Scene(bp,600,600));
      
   }

   public void showView(){
      show();
   }
}