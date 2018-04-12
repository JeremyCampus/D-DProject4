package main.java.heroes.items.attack;

import main.java.heroes.items.*;
import java.util.ArrayList;
import java.util.List;

import main.java.heroes.*;

public class Spell extends AttackItem{
	protected static List<Item> spellList = new ArrayList();
	
	public Spell() {
		super();
		type = "Weapon";
		attackLevel = 1;
		guerrierUser = true;
	}

	public static void generateSpells() {
		spellList.add(new Thunder());
		spellList.add(new Invisibility());
		spellList.add(new WallOfFire());
	}
	
	public static List<Item> getSpellList(){
		return spellList;
	}
}