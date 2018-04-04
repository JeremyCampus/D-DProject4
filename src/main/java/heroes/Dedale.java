package main.java.heroes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import main.java.heroes.perso.*;
import main.java.heroes.perso.Character;
import main.java.heroes.enemy.*;

public class Dedale {

	static List<Character> listeHeroes = new ArrayList<Character>();
	static List<Event> monDonjon = new ArrayList<Event>();
	protected static int mySquare = 0;
	protected static int limitSquares = 63;

	



	public static void main(String[] args) {
		createCharacter();
		generateDonjon();
		Scanner sc = new Scanner(System.in);
		boolean quitter = false;	
		Interface.clearZone();		  
			do{
				if(mySquare < limitSquares ){
					Interface.menuPrincipal();
					String str2 = sc.nextLine();
					Interface.clearZone();
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
////////////////////CONSOLE ADMIN / CHEAT CODES//////////////////////
						case "42":
							Dedale.cheatCodeConsole();
							break; 
/////////////////////////END///////////////////////////
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
	
	
//-------------------------Selectionner/modifier Un personnage
public static void gestionDuHero(int numHero){
	boolean exit = false;
	Scanner sc = new Scanner(System.in);
	Interface.clearZone();		  
	do{
		listeHeroes.get(0).mettreAJour();
		Interface.menuGestionHero();
		String str2 = sc.nextLine();
		Interface.clearZone();
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
	Interface.clearZone();		  
		do{
			Interface.menuGestionInventory();
			String str2 = sc.nextLine();
			Interface.clearZone();
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
	
	//-------------------------GESTION SQUARES/DONJON

	public static int getmySquare() {
		return mySquare;
	}
	
	
	public static void setmySquare(int newmySquare) {
		mySquare = newmySquare;
	}
	
	public static void generateDonjon() {
		setmySquare(0);
		
		for(int i = 0; i < limitSquares+1; i++){
			Event myEvent = new Event();
			monDonjon.add(myEvent);
		}
		
		feedDonjon();
		
	}
	
	public static void feedDonjon() {
		Dedale.generateMonsters();
		Dedale.generateBoxes();
	}

	public static void generateMonsters()
	{
		Troll[] myTrolls = new Troll[6];
		Sorcerer[] mySorcerers = new Sorcerer[4];
		Succubus[] mySuccubus = new Succubus[4];

		myTrolls[0] = new Troll(80);
		myTrolls[1] = new Troll(60);
		myTrolls[2] = new Troll(40);
		myTrolls[3] = new Troll(30);
		myTrolls[4] = new Troll(20);
		myTrolls[5] = new Troll(15);
		
//		for(int i = 6; i < 59; i++){
//			myTrolls[i] = new Troll(15);
//		}
		
		mySorcerers[0] = new Sorcerer(75);
		mySorcerers[1] = new Sorcerer(50);
		mySorcerers[2] = new Sorcerer(25);
		mySorcerers[3] = new Sorcerer(15);	
		
		mySuccubus[0] = new Succubus(75);
		mySuccubus[1] = new Succubus(50);
		mySuccubus[2] = new Succubus(25);
		mySuccubus[3] = new Succubus(15);	
		
///////////////TROLL////////////////////////////////////////////////////////////////
		for(int i = 0; i < 6; i++){
			boolean trollOk = false;
			int limiteBreak = 0;
			do {
				limiteBreak++;
				int localisation =  1 + (int)(Math.random() * ((limitSquares - 1) + 1));
				System.out.println("TEST" + Dedale.monDonjon.get(localisation));

				if(Dedale.monDonjon.get(localisation) instanceof Event) {
					Dedale.monDonjon.set(localisation, myTrolls[i]);
					trollOk = true;
				}
			}while(trollOk != true || limiteBreak >= 10 );
		}
///////////////SORCERER////////////////////////////////////////////////////////////////
		for(int i = 0; i < 4; i++){
			boolean sorcerersOK = false;
			int limiteBreak = 0;
			do {
				limiteBreak++;
				int localisation =  1 + (int)(Math.random() * ((limitSquares - 1) + 1));
				System.out.println("TEST" + Dedale.monDonjon.get(localisation));

				if(Dedale.monDonjon.get(localisation) instanceof Event) {
					Dedale.monDonjon.set(localisation, mySorcerers[i]);
					sorcerersOK = true;
				}
			}while(sorcerersOK != true || limiteBreak >= 10 );
		}
///////////////SUCCUBUS////////////////////////////////////////////////////////////////
		for(int i = 0; i < 4; i++){
			boolean succubusOK = false;
			int limiteBreak = 0;
			do {
				limiteBreak++;
				int localisation =  1 + (int)(Math.random() * ((limitSquares - 1) + 1));
				System.out.println("TEST" + Dedale.monDonjon.get(localisation));

				if(Dedale.monDonjon.get(localisation) instanceof Event) {
					Dedale.monDonjon.set(localisation, mySuccubus[i]);
					succubusOK = true;
				}
			}while(succubusOK != true || limiteBreak >= 10 );
		}
	}
	
	public static void generateBoxes()
	{
		Troll[] myTrolls = new Troll[6];
		Sorcerer[] mySorcerers = new Sorcerer[4];
		Succubus[] mySuccubus = new Succubus[4];

		myTrolls[0] = new Troll(80);
		myTrolls[1] = new Troll(60);
		myTrolls[2] = new Troll(40);
		myTrolls[3] = new Troll(30);
		myTrolls[4] = new Troll(20);
		myTrolls[5] = new Troll(15);
		
//		for(int i = 6; i < 59; i++){
//			myTrolls[i] = new Troll(15);
//		}
		
		mySorcerers[0] = new Sorcerer(75);
		mySorcerers[1] = new Sorcerer(50);
		mySorcerers[2] = new Sorcerer(25);
		mySorcerers[3] = new Sorcerer(15);	
		
		mySuccubus[0] = new Succubus(75);
		mySuccubus[1] = new Succubus(50);
		mySuccubus[2] = new Succubus(25);
		mySuccubus[3] = new Succubus(15);	
		
///////////////TROLL////////////////////////////////////////////////////////////////
		for(int i = 0; i < 6; i++){
			boolean trollOk = false;
			int limiteBreak = 0;
			do {
				limiteBreak++;
				int localisation =  1 + (int)(Math.random() * ((limitSquares - 1) + 1));
				System.out.println("TEST" + Dedale.monDonjon.get(localisation));

				if(Dedale.monDonjon.get(localisation) instanceof Event) {
					Dedale.monDonjon.set(localisation, myTrolls[i]);
					trollOk = true;
				}
			}while(trollOk != true || limiteBreak >= 10 );
		}
///////////////SORCERER////////////////////////////////////////////////////////////////
		for(int i = 0; i < 4; i++){
			boolean sorcerersOK = false;
			int limiteBreak = 0;
			do {
				limiteBreak++;
				int localisation =  1 + (int)(Math.random() * ((limitSquares - 1) + 1));
				System.out.println("TEST" + Dedale.monDonjon.get(localisation));

				if(Dedale.monDonjon.get(localisation) instanceof Event) {
					Dedale.monDonjon.set(localisation, mySorcerers[i]);
					sorcerersOK = true;
				}
			}while(sorcerersOK != true || limiteBreak >= 10 );
		}
///////////////SUCCUBUS////////////////////////////////////////////////////////////////
		for(int i = 0; i < 4; i++){
			boolean succubusOK = false;
			int limiteBreak = 0;
			do {
				limiteBreak++;
				int localisation =  1 + (int)(Math.random() * ((limitSquares - 1) + 1));
				System.out.println("TEST" + Dedale.monDonjon.get(localisation));

				if(Dedale.monDonjon.get(localisation) instanceof Event) {
					Dedale.monDonjon.set(localisation, mySuccubus[i]);
					succubusOK = true;
				}
			}while(succubusOK != true || limiteBreak >= 10 );
		}
	}
	
	
	
//////////MOVE/////////////////
	public static void move()
	{
		int deplacement = 0;
		deplacement = getmySquare() + 1 + (int)(Math.random() * ((6 - 1) + 1));
		setmySquare(deplacement);
	}
	
	public static void cheatCodeConsole() {
		Scanner sc = new Scanner(System.in);
		boolean quitterCheatCodes = false;	
		do {
			Interface.menuCheatCode();
			String str3 = sc.nextLine();
			Interface.clearZone();
			switch (str3)
			{        
				case "1":
					int str4 = sc.nextInt();
					Dedale.setmySquare(str4);
					break;
				case "2":
					for(int i = 0; i < Dedale.limitSquares; i++){
						System.out.println(Dedale.monDonjon.get(i).afficher());
					}
					break;
				case "4":
					quitterCheatCodes = true;
					break;
				default:
					System.out.println("");
					break;
			}
		}while(quitterCheatCodes != true);
		}
}