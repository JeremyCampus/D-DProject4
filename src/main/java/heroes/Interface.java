package main.java.heroes;

import main.java.heroes.items.*;
import main.java.heroes.items.attack.*;
import main.java.heroes.enemy.*;
import main.java.heroes.supriseBoxes.*;
import main.java.heroes.supriseBoxes.diverse.BoxHealingPotion;

import java.util.Scanner;

public abstract class Interface extends Dedale{
	public static int machin = 0;
	private static Scanner sc = new Scanner(System.in);

	public static void clearZone()
	{
		System.out.print("\033[H\033[2J");  //CLEAR TERMINAL
		System.out.flush();					//CLEAR TERMINAL
		machin = machin +1;
	}
	
	public static void menuPrincipal() {
		Interface.clearZone();		  
		Scanner sc = new Scanner(System.in);
		boolean quitter = false;	
			do{
				if(mySquare < limitSquares ){
					if(!Dedale.monDonjon.get(mySquare).eventFinished)
					{
						if(Dedale.monDonjon.get(mySquare) instanceof Enemy) {
							System.out.println("---");
							System.out.println("Vous etes chez un ennemi, prudence... : " + Dedale.monDonjon.get(mySquare).afficher());
						}
						if(Dedale.monDonjon.get(mySquare) instanceof Box) {
							System.out.println("---");
							System.out.println("Vous appercevez un étrange coffre au loin ! " + Dedale.monDonjon.get(mySquare).afficher());
						}
					}else {
						System.out.println("Evenement terminé, continuez d'avancer ! ");
					}
					
	
					System.out.println("_____________________________________________________________________");
					System.out.println("|||||||||||||||||||||| QUE VOULEZ VOUS FAIRE ? ||||||||||||||||||||||");
					System.out.println("_____________________________________________________________________");
					System.out.println("-VOUS ETES SUR LA CASE N " + getmySquare() + " -");
					System.out.println("---");
					System.out.println("Afficher le personnages ? = 1");
					System.out.println("Selectionner un personnage ? = 2");
					System.out.println("Vous soigner ? ( " + listeHeroes.get(0).getNbHealingPotion() + " potions restante(s)) = 3");
					
					if(Dedale.monDonjon.get(mySquare).getClass().equals(Event.class)||Dedale.monDonjon.get(mySquare).eventFinished)
					{
						System.out.println("Vous deplacer ? = 4");
					}else {
						System.out.println("Vous entrer dans la salle ? = 4");
					}
					System.out.println("Quitter = 5");
					System.out.println("---");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("_____________________________________________________________________");
					System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
					System.out.println("_____________________________________________________________________");
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
									Interface.menuGestionHero();	
								} catch (Exception e) {
									System.out.println("erreur");
								}      
								break;  
							case "3":
								System.out.println("test");
								System.out.println(Dedale.listeHeroes.get(0).healing());
								break;       
							case "4":
								if(Dedale.monDonjon.get(mySquare).getClass().equals(Event.class))
								{
									Dedale.monDonjon.get(mySquare).eventFinished = true;
								}
								if(Dedale.monDonjon.get(mySquare).eventFinished)
								{
									move();
								}else {
									Dedale.monDonjon.get(mySquare).generateEvent();
								}
								break;   
							case "5":
								quitter = true;
								break; 
	////////////////////CONSOLE ADMIN / CHEAT CODES//////////////////////
							case "42":
								Interface.menuCheatCode();
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
		
	}
	
	public static void menuGestionHero() {
		
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		Interface.clearZone();		  
		do{
			System.out.println("");
			System.out.println("Gestion du hero : " + listeHeroes.get(0).getName());
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
			System.out.println("_____________________________________________________________________");
			System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
			System.out.println("_____________________________________________________________________");
			listeHeroes.get(0).mettreAJour();
			String str2 = sc.nextLine();
			Interface.clearZone();
			switch (str2)
			{
				case "1":
					System.out.println(listeHeroes.get(0));			  
					break;               
				case "2":
					listeHeroes.get(0).afficherInventory();			  
					break;
				case "3":
					Dedale.gestionInventory(0);	
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
	
	
	public static void menuGestionInventory() {
		boolean quitter = false;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("_____________________________________________________________________");
			System.out.println("|||||||||||||||||||||| INVENTAIRE DE "+ listeHeroes.get(0).getName() +" ||||||||||||||||||||||");
			System.out.println("_____________________________________________________________________");
			System.out.println("-VOUS ETES SUR LA CASE N " + getmySquare() + " -");
			System.out.println("Afficher l'Inventaire? = 1");
			System.out.println("Quel arme utilise le Hero actuellement ? = 2");
			System.out.println("Changer l'arme qu'utilise le hero ? = 3");
			System.out.println("Quitter = 4");
			System.out.println("---");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("_____________________________________________________________________");
			System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
			System.out.println("_____________________________________________________________________");
			String str2 = sc.nextLine();
			Interface.clearZone();
			switch (str2)
			{
				case "1":
					listeHeroes.get(0).afficherInventory();
					break;            
				case "2":
					System.out.println(listeHeroes.get(0).whatItemAttack());
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
	
	public static void menuCheatCode(){
		Scanner sc = new Scanner(System.in);
		boolean quitterCheatCodes = false;	
		do {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("_____________________________________________________________________");
			System.out.println("|||||||||||||||||||||| CHEAT CODE CONSOLE ||||||||||||||||||||||");
			System.out.println("_____________________________________________________________________");
			System.out.println("---");
			System.out.println("Changer Case ? = 1");
			System.out.println("Afficher tout = 2");
			System.out.println("//Ajouter Arme Hero ? = 3");
			System.out.println("Ajouter Potion ? = 4 ==> "+ listeHeroes.get(0).getNbHealingPotion() + " potions restante(s))");
			System.out.println("Quitter = 5");
			System.out.println("---");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("_____________________________________________________________________");
			System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
			System.out.println("_____________________________________________________________________");
			String str3 = sc.nextLine();
			Interface.clearZone();
			switch (str3)
			{        
				case "1":
					int str4 = sc.nextInt();
					Dedale.setmySquare(str4);
					break;
				case "2":
					for(int i = 0; i <= limitSquares; i++){
						System.out.println(Dedale.monDonjon.get(i).afficher() + " " + i);
					}
					break;
				case "4":
					BoxHealingPotion newHealingPotion = new BoxHealingPotion();
					newHealingPotion.generateEvent();
					break;
				case "5":
					quitterCheatCodes = true;
					break;
				default:
					System.out.println("");
					break;
			}
		}while(quitterCheatCodes != true);
	
	}
	
	protected static String menuListWeapon()
	{
		System.out.println("Commencer avec :"
				+ " Bow = 1 "
				+ " Mace = 2 "
				+ " Sword = 3");
		String newWeapon = "";
		newWeapon = sc.nextLine();
		return newWeapon;
	}

	protected static String menuListSpell()
	{
		System.out.println("Commencer avec :"
				+ " Thunder = 1 "
				+ " Invisibility = 2 "
				+ " Wall of Fire = 3");
		String newSpell = "";
		newSpell = sc.nextLine();
		return newSpell;
	}

}
