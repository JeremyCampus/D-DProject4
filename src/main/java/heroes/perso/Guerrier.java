package main.java.heroes.perso;
import main.java.heroes.items.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

// import java.util.ListIterator;

public class Guerrier extends Character{
	protected static List<Arme> inventory = new ArrayList<Arme>();	
	public Arme myAttackItem = new Arme();
	public Shield myDefenseItem = new Shield();
	protected int damages =  FA + myAttackItem.getItemAttackLevel();
	protected boolean shield = false;
	protected String metier = "Guerrier";
	
	
	public Guerrier() {
		super();
		inventory.add(myAttackItem);
	}


	public Guerrier(String myName) {
		super();
		name = myName;
		// inventory.add(myAttackItem);
	}


	public Guerrier(String myName, String newImage, int newLife, int newStrenght) {
		setName(myName);
		setImage(newImage);
		setLife(newLife);
		setFA(newStrenght);
		// inventory.add(myAttackItem);
		mettreAJour();
	}
	
	
		
	public void mettreAJour(){
		damages = FA + myAttackItem.getItemAttackLevel();
	}



	public void setShield(boolean status){
		shield = status;
	}


	public void attaquer() {
		System.out.println("Vous attaquez votre ennemi.");
		System.out.println("Vous lui avez fait : " + damages + "degats");
	}

	public String toString() {
		return "\n_________________________________________"		
		+"\nYour Name : " + name 
		+"\nYour Profession : " + metier 
		+ "\nYour Image : " + image 
		+"\nYour Life : " + life +" --- "
		 +"\nYour weapon is " + myAttackItem.getNameItemAttack() + " who deliver " + myAttackItem.getItemAttackLevel() + " damages."
		 +"\nYour shield : " + shield
		 +"\nYour inventory has " + inventory.size() + " Weapons."	
		 +"\n"
		 +"\n_________________________________________";
	}



	public void ajouterArmeSpell(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Une arme ? ");
		myAttackItem = new Arme();

		System.out.println("Son nom : ");
		String str1 = sc.nextLine();
		myAttackItem.setNameItemAttack(str1);

		System.out.println("Son niveau de puissance : ");
		int str2 = sc.nextInt();
		myAttackItem.setItemAttackLevel(str2);
		inventory.add(myAttackItem);
	}


//	public void gestionInventory(){
//		Scanner sc = new Scanner(System.in);
//		boolean quitter = false;	
//		clearZone();		  
//			do{
//				System.out.println("");
//				System.out.println("");
//				System.out.println("");
//				System.out.println("_____________________________________________________________________");
//				System.out.println("|||||||||||||||||||||| INVENTAIRE DE "+ getName() +" ||||||||||||||||||||||");
//				System.out.println("_____________________________________________________________________");
//				System.out.println("---");
//				System.out.println("Afficher l'inventaire ? = 1");
//				System.out.println("Afficher l'arme actuelle pour se battre ? = 2");
//				System.out.println("Choisir l'arme pour se battre ? = 3");
//				System.out.println("Quitter = 4");
//				System.out.println("---");
//				System.out.println("");
//				System.out.println("");
//				System.out.println("");
//				System.out.println("");
//				System.out.println("");
//				String str2 = sc.nextLine();
//				clearZone();
//				System.out.println("_____________________________________________________________________");
//				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
//				System.out.println("_____________________________________________________________________");
//				switch (str2)
//				{
//					case "1":
//						afficherInventory();
//						break;            
//					case "2":
//						System.out.println(getName() + " utilise actuellement l'arme : " + myAttackItem.getNameItemAttack());
//						break;  
//					case "3":
//						selectionnerArme();
//						break;        	
//					case "4":
//						quitter = true;
//						break;   						  
//					default:
//						System.out.println("");
//						break;        
//				}
//			}while(quitter != true);
//	}

	public void afficherInventory(){
		System.out.println("______________||_INVENTAIRE_||______________");
		System.out.println("");
		System.out.println("Your Name : " + name);
		System.out.println("Your inventory has " + inventory.size() + " Weapons.");	
		System.out.println("_________________________________________");		
		for(int i = 0; i < inventory.size(); i++){
			System.out.println("");
			System.out.println("");
			System.out.println("Voici l'arme : " + inventory.get(i).getNameItemAttack() + " | Numero : " + i);
			System.out.println("Voici sa Puissance : " + inventory.get(i).getItemAttackLevel());;
		}	

		// System.out.println("Your weapon is " + myAttackItem.getNameItemAttack() + " who deliver " + myAttackItem.getItemAttackLevel() + " damages.");

	}

	public void selectionnerArme()
	{
		Scanner sc = new Scanner(System.in);		
		afficherInventory();
		System.out.println("______________||QUELLE ARME VOULEZ VOUS UTILISER||______________");
		System.out.println("                     (Indiquez son numero)");
		int str2 = sc.nextInt();
		sc.nextLine();
		myAttackItem= inventory.get(str2);
		System.out.println(getName() + " utilise actuellement l'arme : " + myAttackItem.getNameItemAttack());
	}

	public void supprimerArme()
	{
		Scanner sc3 = new Scanner(System.in);		
		afficherInventory();
		System.out.println("______________||QUELLE ARME VOULEZ VOUS SUPPRIMER||______________");
		System.out.println("                     (Indiquez son numero)");
		int str2 = sc3.nextInt();
		sc3.nextLine();
		System.out.println("Etes vous sur de vouloir supprimer " + inventory.remove(str2) + " ?");
		System.out.println("y(Yes), n(No)");
		String validSuppr = sc3.nextLine();
		if(validSuppr == "y" || validSuppr == "Y")
		{
			inventory.remove(str2);
		}
	}

}