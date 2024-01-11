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



















































