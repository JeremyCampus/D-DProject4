package main.java.heroes.perso;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.heroes.*;
import main.java.heroes.items.*;

import java.util.List;
// import java.util.ListIterator;

public class Mage extends Character{
	static List<Spell> inventory = new ArrayList<Spell>();	
	protected Spell myAttackItem = new Spell("1");
	protected int damages =  FA + myAttackItem.getItemAttackLevel();
	protected boolean shield = false;
	protected String metier = "Mage";
	
	
	public Mage() {
		super();
		// inventory.add(myAttackItem);
	}


	public Mage(String myName) {
		super();
		name = myName;
		// inventory.add(myAttackItem);
	}


	public Mage(String myName, String newImage, int newLife, int newStrenght) {
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
		 +"\nYour Spell is " + myAttackItem.getNameItemAttack() + " who deliver " + myAttackItem.getItemAttackLevel() + " damages."
		 +"\nYour shield : " + shield
		 +"\nYour inventory has " + inventory.size() + " Spells."	
		 +"\n"
		 +"\n_________________________________________";
	}
	


	public void ajouterSpellSpell(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Une Spell ? ");
		myAttackItem = new Spell("1");

		System.out.println("Son nom : ");
		String str1 = sc.nextLine();
		myAttackItem.setNameItemAttack(str1);

		System.out.println("Son niveau de puissance : ");
		int str2 = sc.nextInt();
		myAttackItem.setItemAttackLevel(str2);
		inventory.add(myAttackItem);
	}

	public static void clearZone()
	{
		System.out.print("\033[H\033[2J");  //CLEAR TERMINAL
		System.out.flush();					//CLEAR TERMINAL
	}


	public void afficherInventory(){
		System.out.println("______________||_INVENTAIRE_||______________");
		System.out.println("");
		System.out.println("Your Name : " + name);
		System.out.println("Your inventory has " + inventory.size() + " Spells.");	
		System.out.println("_________________________________________");		
		for(int i = 0; i < inventory.size(); i++){
			System.out.println("");
			System.out.println("");
			System.out.println("Voici le Spell : " + inventory.get(i).getNameItemAttack() + " | Numero : " + i);
			System.out.println("Voici sa Puissance : " + inventory.get(i).getItemAttackLevel());;
		}	

		// System.out.println("Your Spell is " + myAttackItem.getNameSpell() + " who deliver " + myAttackItem.getItemAttackLevel() + " damages.");

	}

	public void selectionnerSpell()
	{
		Scanner sc = new Scanner(System.in);		
		afficherInventory();
		System.out.println("______________||QUELLE Spell VOULEZ VOUS UTILISER||______________");
		System.out.println("                     (Indiquez son numero)");
		int str2 = sc.nextInt();
		sc.nextLine();
		myAttackItem= inventory.get(str2);
		System.out.println(getName() + " utilise actuellement l'Spell : " + myAttackItem.getNameItemAttack());
	}

	public void supprimerSpell()
	{
		Scanner sc3 = new Scanner(System.in);		
		afficherInventory();
		System.out.println("______________||QUELLE Spell VOULEZ VOUS SUPPRIMER||______________");
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