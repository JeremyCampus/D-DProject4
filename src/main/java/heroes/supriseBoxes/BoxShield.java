package main.java.heroes.supriseBoxes;

import main.java.heroes.*;


public class BoxShield extends Event{
	public String nameEvent = "Shield";
	public int protection = 1;
	
	
	public BoxShield() {
		
	}
	
	public String afficher() {
		return "Je suis : Un " + nameEvent;
	}
}
