package eu.zoho.chaotx.app.data;

import javafx.beans.property.*;

public class Booking{

   private StringProperty bemerkung;
   private IntegerProperty iban;

   public Booking(){

   }

   public StringProperty bemerkung(){
      return bemerkung;
   }
   public IntegerProperty iban(){
      return iban;
   }

}


