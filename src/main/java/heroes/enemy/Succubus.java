package main.java.heroes.enemy;

public class Succubus extends Enemy{

	public Succubus(int newDamage){
		super();
		combatGuerrier = true;
		damage = newDamage;
		protection = 2;
	}
	
	public String afficher() {
		return "Je suis : une Succubus";
	}
}
