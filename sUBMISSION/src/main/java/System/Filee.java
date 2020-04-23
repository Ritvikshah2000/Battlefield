package System;

import java.util.*;

class Filee extends Node {
	
    private List<Observer> observerList = new ArrayList<Observer>();

	
	Filee(String n, Directory p) {
		super(n, p);
	}

	public List<String> find(String s) {
		List<String> result = new ArrayList<String>();
		if (_name.indexOf(s) != -1) {
			result.add(this.getAbsoluteName());
		}
		return result;
	}
	
	public void attach(Observer obs) {
		if(!observerList.contains(obs)) {
			observerList.add(obs);
		}
	}
	
	public void detach(Observer obs) {
		observerList.remove(obs);
	}
	
	public void write(String s) {
		notifyObservers();
	}
	
	public void notifyObservers() {
		
		for(Observer temp : observerList) {
			temp.update();
		}
	}
}
