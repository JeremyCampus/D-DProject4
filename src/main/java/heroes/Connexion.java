package main.java.heroes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.*;
import java.util.*;


public class Connexion {
	private static Scanner sc = new Scanner(System.in);

	
	public static void fullInfo() {
		
	try {
	      System.out.println("Driver O.K.");

	      String url = "jdbc:mysql://localhost:3306/bd4";
	      String user = "GameMaster";
	      String passwd = "meta";

	      Connection truk = DriverManager.getConnection(url, user, passwd);
	      System.out.println("Connexion okay !");         
	         
	      Statement state = truk.createStatement();
	      
	      ResultSet result = state.executeQuery("SELECT * FROM heroes");
	      
	      ResultSetMetaData resultMeta = result.getMetaData();
	         
	      while(result.next()){         
	        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	          System.out.print("\t" + result.getObject(i).toString() + "\t \n|");
	        
	      }
	      System.out.println("Name ?");
	      String setNameHero = sc.nextLine();

	      System.out.println("Image ?");
	      String setImageHero = sc.nextLine();

	      System.out.println("Life ?");
	      int setLifeHero = sc.nextInt();

	      System.out.println("Potion ?");
	      int setPotionHero = sc.nextInt();
	      
	      
	      PreparedStatement insertHero = truk.prepareStatement("insert into heroes (name,image,life,nbHealingPotion) value (?,?,?,?)");
	      insertHero.setString(1, setNameHero);
	      insertHero.setString(2, setImageHero);
	      insertHero.setInt(3, setLifeHero);
	      insertHero.setInt(4, setPotionHero);
	      
	      
	      insertHero.executeUpdate();
	      
	      result.close();
	      state.close();
	         
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.out.println("ERROR CONNEXION !");         

	    }     

	}

	

}
