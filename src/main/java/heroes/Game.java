package main.java.heroes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import main.java.heroes.items.attack.Spell;
import main.java.heroes.items.attack.Weapon;
import main.java.heroes.items.defense.ProtectionPotion;
import main.java.heroes.items.defense.Shield;
import main.java.heroes.perso.Character;

public class Game {
	protected  List<Character> listeHeroes = new ArrayList<Character>();
	protected  List<Event> monDonjon = new ArrayList<Event>();
	protected  int limitSquares = 63;
	
	public void Game() {

	}
	
	public List<Character> getListeHeroes() {
		return listeHeroes;
	//	Factory.getInstanceListHeroes(); 
	}
	
	//-------------------------GESTION SQUARES/DONJON
	
	
	public void initialiser() {
		
		Weapon.generateWeapons();
		Spell.generateSpells();
		Shield.generateShields();
		ProtectionPotion.generateProtectionPotions();
		
		Factory.createCharacter();
		Factory.generateDonjon();
	}
	
	

	public void gestionInventory(int numHero){
		Interface.clearZone();		  
		Interface.menuGestionInventory();
			
	}
}
