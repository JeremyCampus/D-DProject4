package main.java.heroes;

import java.util.Scanner;

import main.java.heroes.enemy.Sorcerer;
import main.java.heroes.enemy.Succubus;
import main.java.heroes.enemy.Troll;
import main.java.heroes.items.attack.Spell;
import main.java.heroes.items.attack.Weapon;
import main.java.heroes.items.defense.ProtectionPotion;
import main.java.heroes.items.defense.Shield;
import main.java.heroes.perso.Character;
import main.java.heroes.perso.Guerrier;
import main.java.heroes.perso.Mage;
import main.java.heroes.supriseBoxes.BoxProtectionPotion;
import main.java.heroes.supriseBoxes.BoxShield;
import main.java.heroes.supriseBoxes.BoxSpell;
import main.java.heroes.supriseBoxes.BoxWeapon;
import main.java.heroes.supriseBoxes.diverse.BoxBonus;
import main.java.heroes.supriseBoxes.diverse.BoxHealingPotion;

public class Factory {

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

			
			int newLife =25;
//			System.out.println("Quel est votre life ?");
//			newLife = sc.nextInt();

			int newStrenght = 1;
//			System.out.println("Quel est votre Strenght ?");
//			newStrenght = sc.nextInt();	

			if(vocation == 1){

				String newWeapon = Interface.menuListWeapon();

				myHero = new Guerrier(myName, newImage, newLife, newStrenght, newWeapon);

			}else{
				String newSpell = Interface.menuListSpell();

				myHero = new Mage(myName, newImage, newLife, newStrenght, newSpell);
			}
			Dedale.myGame.listeHeroes.add(myHero);
		}
		
		public static void generateDonjon() {
			Dedale.myGame.listeHeroes.get(0).setMySquare(0);
			
			for(int i = 0; i <= Dedale.myGame.limitSquares; i++){
				Event myEvent = new Event();
				Dedale.myGame.monDonjon.add(myEvent);
			}
			
			feedDonjon();
			
		}
		
		public static void feedDonjon() {
			generateMonsters();
			generateBoxes();
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
					int localisation =  (int)(Math.random() * ((Dedale.myGame.limitSquares - 1) + 1));
					System.out.println("Je suis troll n " +i + " a la place n "+localisation);

					if(Dedale.myGame.monDonjon.get(localisation).getClass().equals(Event.class)) {
						Dedale.myGame.monDonjon.set(localisation, myTrolls[i]);
						trollOk = true;
					}
				}while(trollOk != true);
			}
	///////////////SORCERER////////////////////////////////////////////////////////////////
			for(int i = 0; i < 4; i++){
				boolean sorcerersOK = false;
				int limiteBreak = 0;
				do {
					limiteBreak++;
					int localisation =  (int)(Math.random() * ((Dedale.myGame.limitSquares - 1) + 1));
					System.out.println("Je suis Sorcerer n " +i + " a la place n "+localisation );

					if(Dedale.myGame.monDonjon.get(localisation).getClass().equals(Event.class)) {
						Dedale.myGame.monDonjon.set(localisation, mySorcerers[i]);
						sorcerersOK = true;
					}
				}while(sorcerersOK != true);
			}
	///////////////SUCCUBUS////////////////////////////////////////////////////////////////
			for(int i = 0; i < 4; i++){
				boolean succubusOK = false;
				int limiteBreak = 0;
				do {
					limiteBreak++;
					int localisation =  (int)(Math.random() * ((Dedale.myGame.limitSquares - 1) + 1));
					System.out.println("Je suis Succubus n " +i + " a la place n "+localisation );

					if(Dedale.myGame.monDonjon.get(localisation).getClass().equals(Event.class)) {
						Dedale.myGame.monDonjon.set(localisation, mySuccubus[i]);
						succubusOK = true;
					}
				}while(succubusOK != true);
			}
		}
		
		public static void generateBoxes()
		{
			BoxWeapon[] myBoxWeapon = new BoxWeapon[Weapon.getWeaponList().size()];
			BoxSpell[] myBoxSpell = new BoxSpell[Spell.getSpellList().size()];
			BoxShield[] myBoxShield = new BoxShield[Shield.getShieldList().size()];
			BoxProtectionPotion[] myBoxProtectionPotion = new BoxProtectionPotion[ProtectionPotion.getProtectionPotionList().size()];
			


			BoxHealingPotion[] myHealingPotion = new BoxHealingPotion[2];
			myHealingPotion[0] = new BoxHealingPotion();
			myHealingPotion[1] = new BoxHealingPotion();
			
			BoxBonus[] myBoxBonus = new BoxBonus[3];
			myBoxBonus[0] = new BoxBonus(1);
			myBoxBonus[1] = new BoxBonus(1);
			myBoxBonus[2] = new BoxBonus(2);

		

			
	///////////////Box weapon////////////////////////////////////////////////////////////////
			for(int i = 0; i < Weapon.getWeaponList().size(); i++){
				boolean weaponOk = false;
				int limiteBreak = 0;
				do {
					limiteBreak++;
					int localisation =  (int)(Math.random() * ((Dedale.myGame.limitSquares - 1) + 1));
					System.out.println("Je suis BoxWeapon n " +i + " a la place n "+localisation );

					if(Dedale.myGame.monDonjon.get(localisation).getClass().equals(Event.class)) {
						myBoxWeapon[i] = new BoxWeapon(Weapon.getWeaponList().get(i));
						Dedale.myGame.monDonjon.set(localisation, myBoxWeapon[i]);
						weaponOk = true;
					}
				}while(weaponOk != true);
			}
	///////////////Box Spell////////////////////////////////////////////////////////////////
		for(int i = 0; i < Spell.getSpellList().size(); i++){
			boolean SpellOK = false;
			int limiteBreak = 0;
			do {
				limiteBreak++;
				int localisation =  (int)(Math.random() * ((Dedale.myGame.limitSquares - 1) + 1));
				System.out.println("Je suis BoxSpell n " +i + " a la place n "+localisation );

				if(Dedale.myGame.monDonjon.get(localisation).getClass().equals(Event.class)) {
					myBoxSpell[i] = new BoxSpell(Spell.getSpellList().get(i));
					Dedale.myGame.monDonjon.set(localisation, myBoxSpell[i]);
					SpellOK = true;
				}
			}while(SpellOK != true);
		}

	/////////////////Box SHIELD////////////////////////////////////////////////////////////////
		for(int i = 0; i < Shield.getShieldList().size(); i++){
			
			boolean ShieldOK = false;
			int limiteBreak = 0;
			do {
				limiteBreak++;
				int localisation =  (int)(Math.random() * ((Dedale.myGame.limitSquares - 1) + 1));
				System.out.println("Je suis shield n " +i + " a la place n "+localisation );

				if(Dedale.myGame.monDonjon.get(localisation).getClass().equals(Event.class)) {
					myBoxShield[i] = new BoxShield(Shield.getShieldList().get(i));
					Dedale.myGame.monDonjon.set(localisation, myBoxShield[i]);
					ShieldOK = true;
				}
			}while(ShieldOK != true);
		}

	/////////////////Box PROTECTION POTION////////////////////////////////////////////////////////////////
	for(int i = 0; i < ProtectionPotion.getProtectionPotionList().size(); i++){
		boolean protecPotionOK = false;
		int limiteBreak = 0;
		do {
			limiteBreak++;
			int localisation =  (int)(Math.random() * ((Dedale.myGame.limitSquares - 1) + 1));
			System.out.println("Je suis boxProtectionPotion n " +i + " a la place n "+localisation );
			
			if(Dedale.myGame.monDonjon.get(localisation).getClass().equals(Event.class)) {
				myBoxProtectionPotion[i] = new BoxProtectionPotion(ProtectionPotion.getProtectionPotionList().get(i));
				Dedale.myGame.monDonjon.set(localisation, myBoxProtectionPotion[i]);
				protecPotionOK = true;
			}
		}while(protecPotionOK != true);
	}

	///////////////HEALING POTION////////////////////////////////////////////////////////////////
			for(int i = 0; i < myHealingPotion.length; i++){
				boolean healingPotionOK = false;
				int limiteBreak = 0;
				do {
					limiteBreak++;
					int localisation =  (int)(Math.random() * ((Dedale.myGame.limitSquares - 1) + 1));
					System.out.println("Je suis healingPotion n " +i + " a la place n "+localisation );
		
					if(Dedale.myGame.monDonjon.get(localisation).getClass().equals(Event.class)) {
						Dedale.myGame.monDonjon.set(localisation, myHealingPotion[i]);
						healingPotionOK = true;
					}
				}while(healingPotionOK != true);
			}
	///////////////// BONUS / MALUS ////////////////////////////////////////////////////////////////
		for(int i = 0; i < myBoxBonus.length; i++){
			boolean bonusOK = false;
			int limiteBreak = 0;
			do {
				limiteBreak++;
				int localisation =  (int)(Math.random() * ((Dedale.myGame.limitSquares - 1) + 1));
				System.out.println("Je suis myBoxBonus n " +i + " a la place n "+localisation );

				if(Dedale.myGame.monDonjon.get(localisation).getClass().equals(Event.class)) {
					Dedale.myGame.monDonjon.set(localisation, myBoxBonus[i]);
					bonusOK = true;
				}
			}while(bonusOK != true);
		}
	}

		
		
}
