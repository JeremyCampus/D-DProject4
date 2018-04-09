package main.java.heroes.items;

import java.util.ArrayList;
import java.util.List;

public class AttackItem extends Item{
	protected int AttackItemDamage = 1;

	public AttackItem() {

	}


	public String getNameItemAttack(){
		return nameAttackItem;
	}

	public int getItemAttackLevel(){
		return AttackItemDamage;
	}

	

	public void setNameItemAttack(String newName){
		nameAttackItem = newName;
	}

	public void setItemAttackLevel(int newAttackItemDamage){
		AttackItemDamage = newAttackItemDamage;
	}
}
