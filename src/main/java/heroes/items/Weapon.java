package main.java.heroes.items;

import java.util.ArrayList;
import java.util.List;

public class Weapon extends AttackItem {
	protected List<String> listeWeapon = new ArrayList<String>();

	protected String type = "Arme";

	

	public Weapon(String myWeapon) {
		init(myWeapon);
	}
	
	public String nomArme() {
		return listeWeapon.get(0);
	}
	
	public void init(String myWeapon) {
		switch (myWeapon)
		{
			case "1":
				listeWeapon.add("Bow");
				break;            
			case "2":
				listeWeapon.add("Mace");
				break;  
			case "3":
				listeWeapon.add("Sword");
				break;        	  						  
			default:
				System.out.println("Nothing");
				break;        
		}
	}

}