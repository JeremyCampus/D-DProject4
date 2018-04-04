package main.java.heroes.items;


public class DefenseItem extends Item{
	protected int AttackItemDamage = 1;

	public DefenseItem() {

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
