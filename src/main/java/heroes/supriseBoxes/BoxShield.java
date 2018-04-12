package main.java.heroes.supriseBoxes;

import main.java.heroes.items.defense.*;
import main.java.heroes.perso.Guerrier;
import main.java.heroes.*;
import main.java.heroes.items.*;


public class BoxShield extends BoxDefense{
	protected Shield myShield= new Shield(1);
	
	
	
	
	
	public BoxShield(Item newShield) {
		myShield = (Shield) newShield;
	}
	
	
	public String afficher() {
		return "Je suis : Une " + nameEvent + " et Je contiens : " + myShield.getName();
	}
	
	public void generateEvent() {
		if(Dedale.getListeHeroes().get(0).getClass() == Guerrier.class)
		{
			Dedale.getListeHeroes().get(0).ajouterProtection(myShield);
		}
		eventFinished = true;
	}
}
