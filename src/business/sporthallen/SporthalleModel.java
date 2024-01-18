package business.sporthallen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ownUtil.ConcreteObservable;
import ownUtil.ConcreteObserver;



public class SporthalleModel implements ConcreteObservable {
	
	private static SporthalleModel instance;
	private ArrayList<Sporthalle> sporthallen = new ArrayList<Sporthalle>();
	private ArrayList <ConcreteObserver> observers = new ArrayList<ConcreteObserver>();
	BufferedWriter aus;
	
	public static SporthalleModel getInstance() {
		if(instance == null) {
			instance = new SporthalleModel();
		}
		return instance;
	}
	
	public void leseSporthallenAusCsvDatei() throws IOException{
		BufferedReader ein = new BufferedReader(new FileReader("Sporthallen.csv"));
		
		ArrayList<Sporthalle> ergebnis = new ArrayList<Sporthalle>();
		String zeileStr = ein.readLine();
		
		while(zeileStr != null) {
			String [] zeile = zeileStr.split(";");
			ergebnis.add(new Sporthalle(zeile[0], zeile[1], zeile[2]));
			zeileStr = ein.readLine();
		}
		ein.close();
		this.sporthallen =ergebnis;
	}
	
	
	
	private  SporthalleModel() {
		super();
	}
	public ArrayList<Sporthalle> getSporthallen() {
		return sporthallen;
	}

	@Override
	public void addObserver(ConcreteObserver obs) {
		// TODO Auto-generated method stub
		observers.add(obs);	
	}

	@Override
	public void removeObserver(ConcreteObserver obs) {
		// TODO Auto-generated method stub
		observers.remove(obs);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub

		for (ConcreteObserver obs : observers) {
            obs.update();
		}

	}
	
}

