package main.java.heroes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import main.java.heroes.perso.*;
import main.java.heroes.perso.Character;
import main.java.heroes.items.*;

public abstract class Interface {

	public static void clearZone()
	{
		System.out.print("\033[H\033[2J");  //CLEAR TERMINAL
		System.out.flush();					//CLEAR TERMINAL
	}
	
	public void mainMenu(){
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
}
	
}
