package main.java.heroes.enemy;

import main.java.heroes.*;


public class Enemy extends Event{
	public int life = 30;
	public String nameEnemy = "mechant";
	public int damage = 1;
	public int protection = 1;
	
	public Enemy() {
		
	}
	
	public String afficher() {
		return "Je suis : Enemy";
	}
	
	public void generateEvent() {
		eventFinished = true;
	}
}
