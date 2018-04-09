package main.java.heroes.supriseBoxes;

import main.java.heroes.*;
import main.java.heroes.items.*;


public class BoxWeapon extends BoxAttack{
	protected Item monArme= new AttackItem();
	
	public BoxWeapon(String monNum) {
		monArme = new Weapon(monNum);
		
	}
	
	public String afficher() {
		return "Je suis : Une " + nameEvent + " et Je contiens : " + monArme.nomArme();
	}
}
