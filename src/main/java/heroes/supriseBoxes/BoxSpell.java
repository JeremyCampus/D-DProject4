package main.java.heroes.supriseBoxes;

import main.java.heroes.items.attack.*;
import main.java.heroes.perso.Guerrier;
import main.java.heroes.perso.Mage;
import main.java.heroes.*;
import main.java.heroes.items.*;


public class BoxSpell extends BoxAttack{
	protected Spell mySpell= new Spell();
	
	
	public BoxSpell(Item newSpell) {
		mySpell = (Spell) newSpell;
	}
	
	public String afficher() {
		return "Je suis : Une " + nameEvent + " et Je contiens : " + mySpell.getName();
	}
	
	public void generateEvent() {
		if(Dedale.myGame.getListeHeroes().get(0).getClass() == Mage.class)
		{
			Dedale.myGame.getListeHeroes().get(0).ajouterArmeSpell(mySpell);
		}
		eventFinished = true;
	}
}
