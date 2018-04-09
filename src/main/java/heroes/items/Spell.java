package main.java.heroes.items ;

import java.util.ArrayList;
import java.util.List;

import main.java.heroes.*;


public class Spell extends AttackItem{

	protected String type = "Spell";
	protected List<String> listeSpells = new ArrayList<String>();
	

	public Spell(String mySpell) {
		init(mySpell);
	}
	
	public void init(String mySpell) {
		switch (mySpell)
		{
			case "1":
				listeSpells.add("Thunder");
				break;            
			case "2":
				listeSpells.add("Invisibility");
				break;  
			case "3":
				listeSpells.add("Wall of Fire");
				break;        	  						  
			default:
				System.out.println("Nothing");
				break;        
		}
	}
	

}