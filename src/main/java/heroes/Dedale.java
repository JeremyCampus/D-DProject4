package main.java.heroes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;




public class Dedale {
	public static Game myGame = new Game(); 
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		  
		        	
		        Connexion.fullInfo();
		        
		        
		        boolean ENDGAME = false;
				do {
					myGame = new Game();
					myGame.initialiser(); 
					
					Interface.menuPrincipal();
 					String choix = sc.nextLine();
					if(choix == "Y")
					{
						ENDGAME = true;
					}else {
						System.out.println("RESTART");
					}
				}while(!ENDGAME);
		        
		      
		
		
		
		System.out.println("___________________Merci De Votre Visite (^_^)_______________________");



	}
	



}