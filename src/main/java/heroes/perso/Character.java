package main.java.heroes.perso;

import java.util.ArrayList;
import java.util.List;

import main.java.heroes.items.*;
import main.java.heroes.items.attack.*;
import main.java.heroes.items.defense.*;

public abstract class Character {
	protected  List<Item> inventory = new ArrayList<Item>();	
	protected  List<Item> protectionInventory = new ArrayList<Item>();	
	protected String name = "Peasant";
	protected String image  = "X";
	protected int life = 1 + (int)(Math.random() * ((100 - 1) + 1));
	protected int level = 1;
	public int nbHealingPotion = 3;
	protected int FA = 1; 
	protected int damages = FA;
	protected int metier = 0;
	public AttackItem myAttackItem = new AttackItem();
	public DefenseItem myDefenseItem = new DefenseItem();
	protected int mySquare = 0;

	public Character() {
	}

	
	public void mettreAJour(){
		damages = FA;
	}

	public String healing() {
		if(nbHealingPotion>0)
		{
			
			int heal =(int)(Math.random() * ((50 - 25) + 1))  + 25;
			setLife(getLife() + heal);
			if(getLife() > 100)
			{
				setLife(100);
			}
			nbHealingPotion--;
			return "Vous etes soigne de :" + heal + "points de vie.\n Vous avez : " + getLife() + " Points de vie.";
		}else {
			return "plus de potion disponible !\n Vous avez : " + getLife() + " Points de vie.";
		}
	}

	public String getName(){
		return name;
	}

	public String getImage(){
		return image;
	}

	public int getLife(){
		return life;
	}
	
	public int getNbHealingPotion(){
		return nbHealingPotion;
	}


	public int getStrength(){
		return FA;
	}
	
	public int getDamages(){
		return damages;
	}

	//----------------------------

	public void setName(String newNom){
		name = newNom;
	}

	public void setImage(String newImage){
		image = newImage;
	}

	public void setLife(int newLife){
		life = newLife;
	}

	public void setFA(int newFA){
		FA = newFA;
	}

	public String toString() {
		return  "Your Name : " + name 
		+ "Your Image : " + image 
		+"Your Life : " + life +" --- "
		 +"_________________________________________";
	}

	public int getMySquare() {
		return mySquare;
	}

	
	public void setMySquare(int newSquare) {
		mySquare = newSquare;
	}


	

	public void ajouterArmeSpell(){
	}
	public void ajouterArmeSpell(AttackItem myWeapon){
	}

	
	public void ajouterProtection(DefenseItem myProtection){
	}

	public void afficherInventory(){
	}

	public void gestionInventory(){
	}		
	
	public void selectionnerArme(){
	}
	
	public void selectionnerSpell(){
	}
	public String whatItemAttack() {
		return getName() + " utilise actuellement l'arme ";
	}
	

	public int getMetier()
	{
		return metier;
	}
	
	
//////////MOVE/////////////////
public void move()
{
	int deplacement = 0;
	deplacement = getMySquare() + 1 + (int)(Math.random() * ((6 - 1) + 1));
	setMySquare(deplacement);
}
}