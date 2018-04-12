package main.java.heroes.items.defense;

import main.java.heroes.items.*;
import main.java.heroes.items.attack.Bow;
import main.java.heroes.items.attack.Mace;
import main.java.heroes.items.attack.Sword;

import java.util.ArrayList;
import java.util.List;

public class Shield extends DefenseItem {
	protected static List<Item> shieldList = new ArrayList();

	public Shield(int level) {
		super();
		type = "Shield level : " + level;
		DefenseLevel = level;
		guerrierUser = true;
	}

	public static void generateShields() {
		shieldList.add(new Shield(2));
		shieldList.add(new Shield(3));
		shieldList.add(new Shield(5));
	}
	
	public static List<Item> getShieldList(){
		return shieldList;
	}

}