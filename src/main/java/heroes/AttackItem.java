package main.java.heroes;

public class AttackItem {
	protected String nameAttackItem = "None";
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
