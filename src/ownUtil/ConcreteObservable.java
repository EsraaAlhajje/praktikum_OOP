package ownUtil;

import java.util.Observer;

public interface ConcreteObservable {
	
	public void addObserver(ConcreteObserver obs);
	public void removeObserver(ConcreteObserver obs);
	public void notifyObservers();
	
	


}
