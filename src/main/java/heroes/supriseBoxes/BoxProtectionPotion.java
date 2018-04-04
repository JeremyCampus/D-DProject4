package main.java.heroes.supriseBoxes;

import main.java.heroes.*;


public class BoxProtectionPotion extends Event{
	public String nameEvent = "Protection Potion";
	public int protection = 1;
	
	
	public BoxProtectionPotion() {
		
	}
	
	public String afficher() {
		return "Je suis : Une " + nameEvent;
	}
}
