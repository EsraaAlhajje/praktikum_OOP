package business;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

import fabrikMethode.ConcreteCsvCreator;
import fabrikMethode.ConcreteTxtCreator;
import fabrikMethode.Creator;
import fabrikMethode.Product;
import ownUtil.ConcreteObservable;
import ownUtil.ConcreteObserver;

public class BuergeraemterModel implements ConcreteObservable{
	

	LinkedList<ConcreteObserver> liste = new LinkedList<ConcreteObserver>();

	private static BuergeraemterModel instanz=null;
	
	public static BuergeraemterModel getInstanz() {
		if(instanz == null) {
			instanz = new BuergeraemterModel();
		}
		return instanz;
		}
	
	//private Buergeramt buergeramt;
	private ArrayList<Buergeramt> buergeramt = new ArrayList<Buergeramt>();
	
	
	private BuergeraemterModel () {
	}
	/*
	public Buergeramt getBuergeramt() {
		return this.buergeramt;
	}
	*/
	
	
	//alle vorhandenen ArrayList mit add bearbeiten (.dd()) 
	public void addBuergeramt(Buergeramt buergeramt) {
		this.buergeramt.add(buergeramt);
		notifyObservers();
	}
	
	
	public ArrayList<Buergeramt> getBuergeramt() {
		return buergeramt;
	}


	
	public void schreibeBuergeraemterInCsvDatei()
	    throws IOException{
		Creator creator =new ConcreteCsvCreator();
		Product writer = creator.factoryMethod();
		for(Buergeramt buergeramt: buergeramt ) {
		writer.fuegeInDateiHinzu(buergeramt);
		}
		writer.schliessDatei();

 	}

	public void schreibeBuergeraemterInTxtDatei()    throws IOException{
		Creator creator =new ConcreteTxtCreator();
		Product writer = creator.factoryMethod();
		for(Buergeramt buergeramt: buergeramt ) {
			writer.fuegeInDateiHinzu(buergeramt);
		}
		writer.schliessDatei();
	}
	

	@Override
	public void addObserver(ConcreteObserver obs) {
		// TODO Auto-generated method stub
		liste.add(obs);
	
	}
	@Override
	public void removeObserver(ConcreteObserver obs) {
		// TODO Auto-generated method stub
		liste.remove(obs);
	
		
	}
	@Override
	public void notifyObservers() {
	// TODO Auto-generated method stub
	for(ConcreteObserver o:liste) {
			o.update();
		}
	}
	

}























































































/*
 * package business.Sporthalle;

import java.io.IOException;
import java.util.ArrayList;

public class Sporthalle {

	// Name der Sporthalle
	private String name;
	// Groesse der Flaeche
	private int anzahlQuadratmeter;
	// Bodenbelag
	private String bodenbelag;

	public Sporthalle(String name, String anzahlQuadratmeter, 
			String bodenbelag)
	    	throws IOException{

			 	this.name = name;
	  	     	this.anzahlQuadratmeter 
					= Integer.parseInt(anzahlQuadratmeter);
	   	    	this.bodenbelag = bodenbelag;
	}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAnzahlQuadratmeter() {
			return anzahlQuadratmeter;
		}
		public void setAnzahlQuadratmeter(int anzahlQuadratmeter) {
			this.anzahlQuadratmeter = anzahlQuadratmeter;
		}
		public String getBodenbelag() {
			return bodenbelag;
		}
		public void setBodenbelag(String bodenbelag) {
			this.bodenbelag = bodenbelag;
		}
    public String gibSporthalleZurueck(char trenner){
        return this.getName() + trenner
                + this.getAnzahlQuadratmeter() + trenner
                + this.getBodenbelag() ;

    }
}
*/




