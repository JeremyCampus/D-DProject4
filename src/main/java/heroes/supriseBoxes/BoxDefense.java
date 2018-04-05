package main.java.heroes.supriseBoxes;

import main.java.heroes.*;


public class BoxDefense extends Event{
	public String nameEvent = "BoxDefense";
	public int protection = 1;
	
	
	public BoxDefense() {
		
	}
	
	public String afficher() {
		return "Je suis : Une " + nameEvent;
	}
}
