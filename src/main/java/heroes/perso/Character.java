package main.java.heroes.perso;

import main.java.heroes.items.*;

public abstract class Character {
	protected String name = "Peasant";
	protected String image  = "X";
	protected int life = 1 + (int)(Math.random() * ((100 - 1) + 1));
	protected int level = 1;
	protected int nbHealingPotion = 3;
	protected int FA = 1; 
	protected int damages = FA;
	protected String metier = "Peasant";
	public AttackItem myAttackItem = new AttackItem();
	public DefenseItem myDefenseItem = new DefenseItem();

	
	public Character() {
		int machin = 2;
	}

	
	public void mettreAJour(){
		damages = FA;
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




	

	public void ajouterArmeSpell(){
	}

	public void afficherInventory(){
	}

	public void gestionInventory(){
	}		
	
	public void selectionnerArme(){
	}
	
	public void selectionnerSpell(){
	}

}