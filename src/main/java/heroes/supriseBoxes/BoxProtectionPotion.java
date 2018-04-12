package main.java.heroes.supriseBoxes;

import main.java.heroes.items.defense.*;
import main.java.heroes.perso.Guerrier;
import main.java.heroes.perso.Mage;
import main.java.heroes.*;
import main.java.heroes.items.*;


public class BoxProtectionPotion extends BoxDefense{
	protected ProtectionPotion myProtectionPotion= new ProtectionPotion(1);
	
	public BoxProtectionPotion(Item newProtectionPotion) {
		myProtectionPotion = (ProtectionPotion) newProtectionPotion;
	}
	
	
	public String afficher() {
		return "Je suis : Une " + nameEvent + " et Je contiens : " + myProtectionPotion.getName();
	}
	
	public void generateEvent() {
		if(Dedale.getListeHeroes().get(0).getClass() == Mage.class)
		{
			Dedale.getListeHeroes().get(0).ajouterProtection(myProtectionPotion);
		}
		eventFinished = true;

	}
}
