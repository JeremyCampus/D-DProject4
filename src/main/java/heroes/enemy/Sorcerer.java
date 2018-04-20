package main.java.heroes.enemy;

import main.java.heroes.Dedale;

public class Sorcerer extends Enemy{
	

	public Sorcerer(int newDamage){
		super();
		damage = newDamage;
	}
	
	public String afficher() {
		return "Je suis : un Sorcerer";
	}

	public void generateEvent() {
		if(Dedale.myGame.getListeHeroes().get(0).getMetier() == 2)
		{
			Dedale.myGame.getListeHeroes().get(0).getDamages();
			System.out.println(afficher() + " a été tué.");
			eventFinished = true;
			
			Dedale.myGame.getListeHeroes().get(0).setLife(Dedale.myGame.getListeHeroes().get(0).getLife()-damage);
				System.out.println("Vous Avez été tué.");
				eventFinished = true;
				
				System.out.println("Vous Avez été tué.");
				eventFinished = true;
		}else {
			System.out.println(afficher() + " Ne combat que les Magiciens.");
			eventFinished = true;
		}
	}
}
