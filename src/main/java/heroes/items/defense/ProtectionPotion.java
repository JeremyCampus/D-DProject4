package main.java.heroes.items.defense;

import main.java.heroes.items.*;
import java.util.ArrayList;
import java.util.List;

public class ProtectionPotion extends DefenseItem {
	protected static List<Item> protectionPotionList = new ArrayList();

	public ProtectionPotion(int level) {
		super();
		type = "Protection Potion level : " + level;
		DefenseLevel = level;
		guerrierUser = true;
	}

	public static void generateShields() {
		protectionPotionList.add(new ProtectionPotion(2));
		protectionPotionList.add(new ProtectionPotion(3));
		protectionPotionList.add(new ProtectionPotion(5));
	}
	
	public static List<Item> getprotectionPotionListList(){
		return protectionPotionList;
	}



}