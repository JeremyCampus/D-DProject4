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
				int thisSquare = Dedale.myGame.listeHeroes.get(0).getMySquare();
				if(thisSquare < Dedale.myGame.limitSquares ){
					if(!Dedale.myGame.monDonjon.get(Dedale.myGame.listeHeroes.get(0).getMySquare()).eventFinished)
					{
						if(Dedale.myGame.monDonjon.get(Dedale.myGame.listeHeroes.get(0).getMySquare()) instanceof Enemy) {
							System.out.println("---");
							System.out.println("Vous etes chez un ennemi, prudence... : " + Dedale.myGame.monDonjon.get(Dedale.myGame.listeHeroes.get(0).getMySquare()).afficher());
						}
						if(Dedale.myGame.monDonjon.get(Dedale.myGame.listeHeroes.get(0).getMySquare()) instanceof Box) {
							System.out.println("---");
							System.out.println("Vous appercevez un étrange coffre au loin ! " + Dedale.myGame.monDonjon.get(Dedale.myGame.listeHeroes.get(0).getMySquare()).afficher());
						}
					}else {
						System.out.println("Evenement terminé, continuez d'avancer ! ");
					}
					
	
					System.out.println("_____________________________________________________________________");
					System.out.println("|||||||||||||||||||||| QUE VOULEZ VOUS FAIRE ? ||||||||||||||||||||||");
					System.out.println("_____________________________________________________________________");
					System.out.println("-VOUS ETES SUR LA CASE N " + Dedale.myGame.listeHeroes.get(0).getMySquare() + " -");
					System.out.println("---");
					System.out.println("Afficher le personnages ? = 1");
					System.out.println("Selectionner un personnage ? = 2");
					System.out.println("Vous soigner ? ( " + Dedale.myGame.listeHeroes.get(0).getNbHealingPotion() + " potions restante(s)) = 3");
					
					if(Dedale.myGame.monDonjon.get(thisSquare).getClass().equals(Event.class)||Dedale.myGame.monDonjon.get(thisSquare).eventFinished)
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
									System.out.println("Voici le hero : " + Dedale.myGame.listeHeroes.get(0).getName());
									System.out.println(Dedale.myGame.listeHeroes.get(0));
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
								System.out.println(Dedale.myGame.listeHeroes.get(0).healing());
								break;       
							case "4":
								if(Dedale.myGame.monDonjon.get(thisSquare).getClass().equals(Event.class))
								{
									Dedale.myGame.monDonjon.get(thisSquare).eventFinished = true;
								}
								if(Dedale.myGame.monDonjon.get(thisSquare).eventFinished)
								{
									Dedale.myGame.listeHeroes.get(0).move();
								}else {
									Dedale.myGame.monDonjon.get(thisSquare).generateEvent();
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
			System.out.println("Gestion du hero : " + Dedale.myGame.listeHeroes.get(0).getName());
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
			Dedale.myGame.listeHeroes.get(0).mettreAJour();
			String str2 = sc.nextLine();
			Interface.clearZone();
			switch (str2)
			{
				case "1":
					System.out.println(Dedale.myGame.listeHeroes.get(0));			  
					break;               
				case "2":
					Dedale.myGame.listeHeroes.get(0).afficherInventory();			  
					break;
				case "3":
					Dedale.myGame.gestionInventory(0);	
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
			System.out.println("|||||||||||||||||||||| INVENTAIRE DE "+ Dedale.myGame.listeHeroes.get(0).getName() +" ||||||||||||||||||||||");
			System.out.println("_____________________________________________________________________");
			System.out.println("-VOUS ETES SUR LA CASE N " + Dedale.myGame.listeHeroes.get(0).getMySquare() + " -");
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
					Dedale.myGame.listeHeroes.get(0).afficherInventory();
					break;            
				case "2":
					System.out.println(Dedale.myGame.listeHeroes.get(0).whatItemAttack());
					break;  
				case "3":
					Dedale.myGame.listeHeroes.get(0).selectionnerArme();
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
			System.out.println("Ajouter Potion ? = 4 ==> "+ Dedale.myGame.listeHeroes.get(0).getNbHealingPotion() + " potions restante(s))");
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
					Dedale.myGame.listeHeroes.get(0).setMySquare(str4);
					break;
				case "2":
					for(int i = 0; i <= Dedale.myGame.limitSquares ; i++){
						System.out.println(Dedale.myGame.monDonjon.get(i).afficher() + " " + i);
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
