package main.java.heroes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import main.java.heroes.perso.*;
import main.java.heroes.perso.Character;
import main.java.heroes.items.*;
import main.java.heroes.enemy.*;

public class Dedale {

	static List<Character> listeHeroes = new ArrayList<Character>();
	protected static int mySquare = 0;
	protected static int limitSquares = 63;
	static List<Event> monDonjon = new ArrayList<Event>();
	Scanner sc = new Scanner(System.in);

	



	public static void main(String[] args) {
		createCharacter();
		generateDonjon();
		Scanner sc = new Scanner(System.in);
		boolean quitter = false;	
		clearZone();		  
			do{
				if(mySquare < limitSquares ){
					System.out.println("_____________________________________________________________________");
					System.out.println("|||||||||||||||||||||| QUE VOULEZ VOUS FAIRE ? ||||||||||||||||||||||");
					System.out.println("_____________________________________________________________________");
					System.out.println("-VOUS ETES SUR LA CASE N " + getmySquare() + " -");
					System.out.println("---");
					System.out.println("Afficher le personnages ? = 1");
					System.out.println("Selectionner un personnage ? = 2");
					System.out.println("Vous soigner ? (" + listeHeroes.get(0).getNbHealingPotion() + " potions restante(s) ) = 3");
					System.out.println("Vous déplacer ? = 4");
					System.out.println("Quitter = 5");
					System.out.println("---");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					String str2 = sc.nextLine();
					clearZone();
					System.out.println("_____________________________________________________________________");
					System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
					System.out.println("_____________________________________________________________________");
					switch (str2)
					{        
						case "1":
								System.out.println("");
								System.out.println("");
								System.out.println("Voici le hero : " + listeHeroes.get(0).getName());
								System.out.println(listeHeroes.get(0));
							break;        
						case "2":
							try {
								gestionDuHero(0);	
							} catch (Exception e) {
								System.out.println("erreur");
							}      
							break;  
						case "3":
							///////////Vous soigner////////////////////////////////////////////////
							break;       
						case "4":
							move();
							break;   
						case "5":
							quitter = true;
							break;   
	 						  
						default:
							System.out.println("");
							break;        
					}
				}else {
					System.out.println("VOUS ETES ARRIVEE A LA FIN ! FELICITATION");
					quitter = true;
				}
			}while(quitter != true);
		System.out.println("___________________Merci De Votre Visite (^_^)_______________________");



	}
	
	public static void clearZone()
	{
		System.out.print("\033[H\033[2J");  //CLEAR TERMINAL
		System.out.flush();					//CLEAR TERMINAL
	}
//-------------------------Selectionner/modifier Un personnage
public static void gestionDuHero(int numHero){
	boolean exit = false;			  
	Scanner sc = new Scanner(System.in);
	clearZone();		  
	do{
		listeHeroes.get(numHero).mettreAJour();
		System.out.println("");
		System.out.println("");
		System.out.println("VOUS AVEZ SELECTIONNE : " +listeHeroes.get(numHero).getName());
		System.out.println("_____________________________________________________________________");
		System.out.println("|||||||||||||||||||||| QUE VOULEZ VOUS FAIRE ? ||||||||||||||||||||||");
		System.out.println("_____________________________________________________________________");
		System.out.println("---");
		System.out.println("Afficher toutes ses infos ? = 1");
		System.out.println("Afficher son inventaire ? = 2");		
		System.out.println("Gestion de son inventaire ? = 3");		
		System.out.println("Quitter  = 4");
		System.out.println("---");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		String str2 = sc.nextLine();
		clearZone();		  		
		System.out.println("_____________________________________________________________________");
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("_____________________________________________________________________");

		switch (str2)
		{
			case "1":
				System.out.println(listeHeroes.get(numHero));			  
				break;               
			case "2":
				listeHeroes.get(numHero).afficherInventory();			  
				break;
			case "3":
				listeHeroes.get(numHero).gestionInventory();			  
				break;       
			case "4":
				exit = true;
				break;        
			default:
				System.out.println("Erreur");
				break;        
		}

	}while(exit != true);
}

public void gestionInventory(){
	Scanner sc = new Scanner(System.in);
	boolean quitter = false;	
	clearZone();		  
		do{
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("_____________________________________________________________________");
			System.out.println("|||||||||||||||||||||| INVENTAIRE DE "+ listeHeroes.get(0).getName() +" ||||||||||||||||||||||");
			System.out.println("_____________________________________________________________________");
			System.out.println("---");
			System.out.println("Afficher l'inventaire ? = 1");
			System.out.println("Afficher l'arme actuelle pour se battre ? = 2");
			System.out.println("Choisir l'arme pour se battre ? = 3");
			System.out.println("Quitter = 4");
			System.out.println("---");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			String str2 = sc.nextLine();
			clearZone();
			System.out.println("_____________________________________________________________________");
			System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
			System.out.println("_____________________________________________________________________");
			switch (str2)
			{
				case "1":
					listeHeroes.get(0).afficherInventory();
					break;            
				case "2":
						System.out.println(listeHeroes.get(0).getName() + " utilise actuellement l'arme : " + listeHeroes.get(0).myAttackItem.getNameItemAttack());
					break;  
				case "3":
						listeHeroes.get(0).selectionnerArme();
					break;        	
				case "4":
					quitter = true;
					break;   						  
				default:
					System.out.println("");
					break;        
			}
		}while(quitter != true );
}


	//-------------------------CREATION PERSONNAGE
	public static void createCharacter()
	{
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Character myHero;

		int vocation = 0;
		System.out.println("Guerrier(1) ou Mage(2) ?");
		vocation = sc2.nextInt();
		

		String myName = "";
		System.out.println("Quel est son nom ?");
		myName = sc.nextLine();

		String newImage ="X";

		int newLife =1;
		System.out.println("Quel est votre life ?");
		newLife = sc.nextInt();

		int newStrenght = 1;
		System.out.println("Quel est votre Strenght ?");
		newStrenght = sc.nextInt();	

		if(vocation == 1){
			myHero = new Guerrier(myName, newImage, newLife, newStrenght);
		}else{
			myHero = new Mage(myName, newImage, newLife, newStrenght);
		}
		listeHeroes.add(myHero);
	}
	
	//-------------------------GESTION DEDALE/SQUARES

	public static int getmySquare() {
		return mySquare;
	}
	
	
	public static void setmySquare(int newmySquare) {
		mySquare = newmySquare;
	}
	
	public static void generateDonjon() {
		setmySquare(0);
		
		for(int i = 0; i < limitSquares; i++){
			Event myEvent = new Event();
			monDonjon.add(myEvent);
		}
		
		feedDonjon();
		
	}
	
	public static void feedDonjon() {
		Troll[] myTrolls = new Troll[6];
		Sorcerer[] mySorcerers = new Sorcerer[4];
		Succubus[] mySuccubus = new Succubus[4];

		myTrolls[0] = new Troll(80);
		myTrolls[1] = new Troll(60);
		myTrolls[2] = new Troll(40);
		myTrolls[3] = new Troll(30);
		myTrolls[4] = new Troll(20);
		myTrolls[5] = new Troll(15);
		
		mySorcerers[0] = new Sorcerer(75);
		mySorcerers[1] = new Sorcerer(50);
		mySorcerers[2] = new Sorcerer(25);
		mySorcerers[3] = new Sorcerer(15);	
		
		mySuccubus[0] = new Succubus(75);
		mySuccubus[1] = new Succubus(50);
		mySuccubus[2] = new Succubus(25);
		mySuccubus[3] = new Succubus(15);	
		
		for(int i = 0; i < 6; i++){
			int localisation =  1 + (int)(Math.random() * ((limitSquares - 1) + 1));
			monDonjon.get(localisation).setEnemy(myTrolls[i]);
		}
		
		
	}

	
	public static void move()
	{
		int deplacement = 0;
		deplacement = getmySquare() + 1 + (int)(Math.random() * ((6 - 1) + 1));
		setmySquare(deplacement);
	}
}