package main.java.heroes.perso;
import main.java.heroes.items.*;
import main.java.heroes.items.attack.*;
import main.java.heroes.items.defense.*;
import main.java.heroes.items.defense.ProtectionPotion;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class Mage extends Character{

	public Spell myAttackItem = new Spell();
	public ProtectionPotion myDefenseItem = new ProtectionPotion(1);
	protected int damages =  FA + myAttackItem.getItemAttackLevel();
	protected int metier = 2;
	
	
	public Mage() {
		super();
		myAttackItem = new Thunder();
		inventory.add(myAttackItem);
	}


	public Mage(String myName) {
		super();
		name = myName;
		myAttackItem = new Thunder();
		inventory.add(myAttackItem);
	}


	public Mage(String myName, String newImage, int newLife, int newStrenght, String newSpell) {
		setName(myName);
		setImage(newImage);
		setLife(newLife);
		setFA(newStrenght);

		switch(newSpell)
		{           
			case "2":
				myAttackItem = (Spell) Spell.getSpellList().get(1);
				Spell.getSpellList().remove(1);
				break;  
			case "3":
				myAttackItem = (Spell) Spell.getSpellList().get(2);
				Spell.getSpellList().remove(2);
				break;        	 						  
			default:
				myAttackItem = (Spell) Spell.getSpellList().get(0);
				Spell.getSpellList().remove(0);
				break; 
		}
		inventory.add(myAttackItem);
		mettreAJour();

	}
	
	
		
	public void mettreAJour(){
		damages = FA + myAttackItem.getItemAttackLevel();
	}



	public void setProtectionPotion(boolean status){
		
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
		 +"\nYour Spell is " + myAttackItem + " who deliver " + myAttackItem.getItemAttackLevel() + " damages."
		 +"\nYour protectionPotion : " + myDefenseItem
		 +"\nYour inventory has " + inventory.size() + " Spell."	
		 +"\n"
		 +"\n_________________________________________";
	}



	public void ajouterArmeSpell(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Un Sort ? ");
		myAttackItem = new Spell();

		System.out.println("Son nom : ");
		String str1 = sc.nextLine();
		myAttackItem.setName(str1);

		System.out.println("Son niveau de puissance : ");
		int str2 = sc.nextInt();
		myAttackItem.setItemAttackLevel(str2);
		inventory.add(myAttackItem);
	}
	
	
	public void ajouterArmeSpell(AttackItem mySpell){
		myAttackItem = (Spell) mySpell;
		inventory.add(myAttackItem);
	}
	
	public void ajouterProtection(DefenseItem myProtectionPotion){
		myDefenseItem = (ProtectionPotion) myProtectionPotion;
		protectionInventory.add(myDefenseItem);
	}




	public void afficherInventory(){
		System.out.println("______________||_INVENTAIRE_||______________");
		System.out.println("");
		System.out.println("Your Name : " + name);
		System.out.println("Your inventory has " + inventory.size() + " Spell.");	
		System.out.println("_________________________________________");		
		for(int i = 0; i < inventory.size(); i++){
			System.out.println("");
			System.out.println("");
			System.out.println("Voici le sort : " + inventory.get(i).getName() + " | Numero : " + i);
			System.out.println("Voici sa Puissance : " + inventory.get(i).getItemAttackLevel());;
		}	

		// System.out.println("Your weapon is " + myAttackItem.getNameItemAttack() + " who deliver " + myAttackItem.getItemAttackLevel() + " damages.");

	}

	public void selectionnerArme()
	{
		Scanner sc = new Scanner(System.in);		
		afficherInventory();
		System.out.println("______________||QUELLE Sort VOULEZ VOUS UTILISER||______________");
		System.out.println("                     (Indiquez son numero)");
		int str2 = sc.nextInt();
		sc.nextLine();
		myAttackItem= (Spell) inventory.get(str2);
		System.out.println(getName() + " utilise actuellement le sort : " + myAttackItem);
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
	
	public String whatItemAttack()
	{
		return (getName() + " utilise actuellement l'arme : " + myAttackItem);
	}

}