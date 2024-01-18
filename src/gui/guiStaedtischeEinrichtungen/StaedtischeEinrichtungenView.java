package gui.guiStaedtischeEinrichtungen;

import java.io.IOException;

import business.BuergeraemterModel;
import business.Buergeramt;
import business.sporthallen.Sporthalle;
import business.sporthallen.SporthalleModel;
import gui.guiBuergeraemter.BuergeraemterControl;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class StaedtischeEinrichtungenView {
	
	//Hier ergaenzen
		
		private BuergeraemterModel buergeraemterModel;
		private SporthalleModel sporthalleModel;
		private StaedtischeEinrichtungenControl staedtischeEinrichtungenControl;
	
	
    	
    	private Pane pane = new  Pane();
    	
    	private Label lblAnzeigeSporthalle = new Label("Anzeige Sporthalle");
    	private TextArea txtAnzeigeSporthalle  = new TextArea();
    	private Button btnAnzeigeSporthalle = new Button("Anzeige");
    	
    	private Label lblAnzeigeBuergeraeamter = new Label("Anzeige Bürgerämter");
    	private TextArea txtAnzeigeBuergeraeamter  = new TextArea();
    	private Button btnAnzeigeBuergeraeamter = new Button("Anzeige");
    	
    
    	public StaedtischeEinrichtungenView(StaedtischeEinrichtungenControl staedtischeEinrichtungenControl,Stage primaryStage, 
    		BuergeraemterModel buergeraemterModel,SporthalleModel sporthalleModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von städtischen " + "Einrichtungen");
    		primaryStage.show();
    		this.staedtischeEinrichtungenControl = staedtischeEinrichtungenControl;
        	this.buergeraemterModel = buergeraemterModel;
        	this.sporthalleModel = sporthalleModel;
        	
    		this.initKomponenten();
    		this.initListener();
    		this.initKomponentenSporthalle();
    		this.initListenerSporthalle();
        	}

        	private void initKomponenten(){
        		// Label
        		Font font = new Font("Arial", 20);
        		lblAnzeigeBuergeraeamter.setLayoutX(310);
        		lblAnzeigeBuergeraeamter.setLayoutY(40);
        		lblAnzeigeBuergeraeamter.setFont(font);
        		lblAnzeigeBuergeraeamter.setStyle("-fx-font-weight: bold;"); 
        		pane.getChildren().add(lblAnzeigeBuergeraeamter);    
            	



        		txtAnzeigeBuergeraeamter.setEditable(false);
        		txtAnzeigeBuergeraeamter.setLayoutX(310);
        		txtAnzeigeBuergeraeamter.setLayoutY(90);
        		txtAnzeigeBuergeraeamter.setPrefWidth(220);
        		txtAnzeigeBuergeraeamter.setPrefHeight(185);
           	pane.getChildren().add(txtAnzeigeBuergeraeamter);        	
            	// Button
           	btnAnzeigeBuergeraeamter.setLayoutX(310);
           	btnAnzeigeBuergeraeamter.setLayoutY(290);
            	pane.getChildren().add(btnAnzeigeBuergeraeamter); 
       }
       
        	

        	private void initKomponentenSporthalle(){
        		// Label
        		Font font = new Font("Arial", 20);
        		lblAnzeigeSporthalle.setLayoutX(20);
        		lblAnzeigeSporthalle.setLayoutY(40);
        		lblAnzeigeSporthalle.setFont(font);
        		lblAnzeigeSporthalle.setStyle("-fx-font-weight: bold;"); 
        		pane.getChildren().add(lblAnzeigeSporthalle);    
            	



        		txtAnzeigeSporthalle.setEditable(false);
        		txtAnzeigeSporthalle.setLayoutX(20);
        		txtAnzeigeSporthalle.setLayoutY(90);
        		txtAnzeigeSporthalle.setPrefWidth(220);
        		txtAnzeigeSporthalle.setPrefHeight(185);
           	pane.getChildren().add(txtAnzeigeSporthalle);        	
            	// Button
           	btnAnzeigeSporthalle.setLayoutX(20);
           	btnAnzeigeSporthalle.setLayoutY(290);
            	pane.getChildren().add(btnAnzeigeSporthalle); 
       }
        	
        	
        	
        	
        	
       private void initListener() {
    	   btnAnzeigeBuergeraeamter.setOnAction(new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeBuergeraemterAn();
	        	} 
   	    });
    }
   
       
     	
       private void initListenerSporthalle() {
    	   btnAnzeigeSporthalle.setOnAction(new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	    			try {
						sporthalleModel.leseSporthallenAusCsvDatei();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            	zeigeSporthalleAn();
	        	} 
   	    });
    }
       
       
    public void zeigeBuergeraemterAn(){
    	      //tit3er                                   
    	if (buergeraemterModel.getBuergeramt().size()>0) {
 		   StringBuffer text = new StringBuffer();
 		   for (Buergeramt buergeramt : buergeraemterModel.getBuergeramt()) {
 		        text.append(buergeramt.gibBuergeramtZurueck(' ')).append("\n");
 		}
 	   
 		  txtAnzeigeBuergeraeamter.setText(text.toString());
    	}
    	
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Bürgeramt aufgenommen!");
    		}
    }	
    
    
    
    public void zeigeSporthalleAn(){
	      //tit3er                                   
	if (sporthalleModel.getSporthallen().size()>0) {
	   StringBuffer text = new StringBuffer();
	   for (Sporthalle sporthalle : sporthalleModel.getSporthallen()) {
	        text.append(sporthalle.gibSporthalleZurueck(' ')).append("\n");
	}
  
	  txtAnzeigeSporthalle.setText(text.toString());
	}
	
		else{
			zeigeInformationsfensterAn(
			"Bisher wurde kein Sporthalle aufgenommen!");
		}
}
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}




















