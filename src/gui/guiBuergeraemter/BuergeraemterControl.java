package gui.guiBuergeraemter;

import java.io.IOException;

import business.BuergeraemterModel;
import javafx.stage.Stage;
import ownUtil.ConcreteObserver;



public class BuergeraemterControl implements ConcreteObserver{

	
	private BuergeraemterView buergeraemterView;
	private BuergeraemterModel buergeraemterModel;

	public BuergeraemterControl(Stage primaryStage){
		this.buergeraemterModel = BuergeraemterModel.getInstanz();
		this.buergeraemterView = new BuergeraemterView(this, primaryStage, 
				buergeraemterModel);
		buergeraemterModel.addObserver(this);
	}

	
	
	
	void schreibeBuergeraemterInDatei(String typ){
	   	try{
	   		if("csv".equals(typ)){
	   			buergeraemterModel.schreibeBuergeraemterInCsvDatei();
	   			buergeraemterView.zeigeInformationsfensterAn(
	   				"Die Buergeraemter wurden gespeichert!");
	   			
	   			
	   			
	   		}
	   		else{
	   			buergeraemterModel.schreibeBuergeraemterInTxtDatei();
	   			buergeraemterView.zeigeInformationsfensterAn(
		   				"Die Buergeraemter wurden gespeichert!");
	   		}
	    } 
	   	
	   	
	   	
	   	
	   	
		catch(IOException exc){
			buergeraemterView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			buergeraemterView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
    }




	@Override
	public void update() {
		// TODO Auto-generated method stub
		buergeraemterView.zeigeBuergeraemterAn();

		
	}

}

























































































/**
 package gui.guiStaedtischeEinrichtungen;

import java.io.IOException;

import business.Buergeraemter.BuergeraemterModel;
import business.Sporthalle.SporthallenModel;
import gui.guiBuergeraemter.BuergeraemterView;
import javafx.stage.Stage;
import ownUtil.Observer;
import java.io.*;


public class StaedtischeEinrichtungenControl implements Observer {
	
	private StaedtischeEinrichtungenView staedtischeEinrichtungenView;
	private BuergeraemterModel buergeraemterModel;
	private SporthallenModel sporthallenModel;
	

	public StaedtischeEinrichtungenControl(Stage primaryStage){
		this.buergeraemterModel = BuergeraemterModel.getInstanz();
		sporthallenModel=SporthallenModel.getInstance();
		this.staedtischeEinrichtungenView = new StaedtischeEinrichtungenView(this, primaryStage,buergeraemterModel, sporthallenModel);
		buergeraemterModel.addObserver(this);
	}

	public void leseSporthallenAusCsv()  {
		System.out.println("SportControl");

		try {
			sporthallenModel.leseSporthallenAusCsvDatei();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			staedtischeEinrichtungenView.zeigeInformationsfensterAn("Fehler beim lesen aus der CSV Datei");		
			}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		staedtischeEinrichtungenView.zeigeBuergeraemterAn();

		
	}
}
	
	

* /
 */