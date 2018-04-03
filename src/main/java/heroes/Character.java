package main.java.heroes;

import java.util.Scanner;

class Character {
	protected String name = "Peasant";
	protected String image  = "X";
	protected int life = 1 + (int)(Math.random() * ((100 - 1) + 1));;
	protected int strength = 1;
	protected int damages = strength;

	public Character() {
	}

	// public Character(String myName, String newImage, int newLife, int newStrenght) {
	// 	setName(myName);
	// 	setImage(newImage);
	// 	setLife(newLife);
	// 	setStrength(newStrenght);
	// 	mettreAJour();1
	// }
	
	
		
	public void mettreAJour(){
		damages = strength;
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

	public int getStrength(){
		return strength;
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

	public void setStrength(int newStreght){
		strength = newStreght;
	}

	public String toString() {
		return  "Your Name : " + name 
		+ "Your Image : " + image 
		+"Your Life : " + life +" --- "
		 +"_________________________________________";
	}
	public void afficher() {
		System.out.println("_________________________________________");
		System.out.println("");
		System.out.println("Your Name : " + getName());
		System.out.println("Your Image : " + getImage());
		System.out.println("Your Life : " + getLife());
		System.out.println("---");
		System.out.println("Your strength : " + getStrength());
		System.out.println("");
		System.out.println("_________________________________________");

	}
	
	public void attaquer() {
		System.out.println("Vous attaquez votre ennemi.");
		System.out.println("Vous lui avez fait : " + getDamages() + "degats");

	}

	public void modifier() {
		Scanner sc = new Scanner(System.in);

		
		System.out.println("Quel est votre nom ?");
		String str1 = sc.nextLine();
		setName(str1);
		System.out.println("Votre Nom est : " + getName());
		
		System.out.println("Quel est votre image ?");
		String str2 = sc.nextLine();
		setImage(str2);
		System.out.println("Votre image est : " + getImage());

		System.out.println("Quel est votre life ?");
		int str3 = sc.nextInt();
		setLife(str3);
		System.out.println("Votre life est : " + getLife());
		
		System.out.println("Quel est votre strength ?");
		int str4 = sc.nextInt();
		setStrength(str4);
		System.out.println("Votre strength est : " + getStrength());
	}
	

	public void ajouterArmeSpell(){
	}

	public void afficherInventory(){
	}

	public void gestionInventory(){
	}		

}