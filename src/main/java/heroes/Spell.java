package main.java.heroes;


class Spell{

	protected String nameSpell = "None";
	protected int spellAttackLevel = 1;

	public Spell() {

	}


	public String getNameSpell(){
		return nameSpell;
	}

	public int getSpellAttackLevel(){
		return spellAttackLevel;
	}

	

	public void setNameSpell(String newNom){
		nameSpell = newNom;
	}

	public void setSpellAttackLevel(int newSpellAttackLevel){
		spellAttackLevel = newSpellAttackLevel;
	}


	public static void main(String[] args) {

	}
}