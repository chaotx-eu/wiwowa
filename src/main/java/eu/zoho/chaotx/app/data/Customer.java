package eu.zoho.chaotx.app.data;

import javafx.beans.property.*;

public class Customer{

   //StringProperty's
   private StringProperty name;
   private StringProperty vorname;
   private StringProperty strasse;
   private StringProperty ort;
   private StringProperty land;
   private StringProperty telefon;
   private StringProperty handy;
   private StringProperty email;
   private StringProperty homepage;
   private StringProperty fax;
   private StringProperty führerschein;
   private StringProperty auto;
   private StringProperty reiseziel;

   //int Property's
   private IntegerProperty plz;
   private IntegerProperty haustier;
   private IntegerProperty personenzahl;


   
   

   public Customer(){

   }

   //StringProperty Methoden
   public StringProperty nameProperty(){
      return name;
   }
   public StringProperty vornameProperty(){
      return vorname;
   }
   public StringProperty strasseProperty(){
      return strasse;
   }
   public StringProperty ortProperty(){
      return ort;
   }
   public StringProperty landProperty(){
      return land;
   }
   public StringProperty telefonProperty(){
      return telefon;
   }
   public StringProperty handyProperty(){
      return handy;
   }
   public StringProperty emailProperty(){
      return email;
   }
   public StringProperty homepageProperty(){
      return homepage;
   }
   public StringProperty faxProperty(){
      return fax;
   }
   public StringProperty führerscheinProperty(){
      return führerschein;
   }
   public StringProperty autoProperty(){
      return auto;
   }

   public StringProperty reisezielProperty(){
      return reiseziel;
   }

   //IntegerProperty Methoden

   public IntegerProperty plz(){
      return plz;
   }
   public IntegerProperty haustier(){
      return haustier;
   }
   public IntegerProperty personenzahl(){
      return personenzahl;
   }

   
   
   
   
}