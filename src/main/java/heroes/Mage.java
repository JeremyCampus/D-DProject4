package main.java.heroes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
// import java.util.ListIterator;

class Mage extends Character{
	static List<Spell> inventory = new ArrayList<Spell>();	
	protected Spell monSpell = new Spell();
	protected int damages =  strength + monSpell.getSpellAttackLevel();
	protected boolean shield = false;
	protected String metier = "Mage";
	
	
	public Mage() {
		super();
		// inventory.add(monSpell);
	}


	public Mage(String myName) {
		super();
		name = myName;
		// inventory.add(monSpell);
	}


	public Mage(String myName, String newImage, int newLife, int newStrenght) {
		setName(myName);
		setImage(newImage);
		setLife(newLife);
		setStrength(newStrenght);
		// inventory.add(monSpell);
		mettreAJour();
	}
	
	
		
	public void mettreAJour(){
		damages = strength + monSpell.getSpellAttackLevel();
	}



	public void setShield(boolean status){
		shield = status;
	}

	public void modifier() {
		super.modifier();
		Scanner sc = new Scanner(System.in);

		System.out.println("Un bouclier ? ");
		System.out.println("Oui = 1");
		int str1 = sc.nextInt();
		if(str1==1){
			setShield(true);
		}else{
			setShield(false);
		}
		System.out.println("Votre bouclier est : " + shield);
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
		 +"\nYour Spell is " + monSpell.getNameSpell() + " who deliver " + monSpell.getSpellAttackLevel() + " damages."
		 +"\nYour shield : " + shield
		 +"\nYour inventory has " + inventory.size() + " Spells."	
		 +"\n"
		 +"\n_________________________________________";
	}
	// public void afficher() {
	// 	System.out.println("_________________________________________");
	// 	System.out.println("");
	// 	System.out.println("Your Name : " + name);
	// 	System.out.println("Your Profession : " + metier);
	// 	System.out.println("Your Image : " + image);
	// 	System.out.println("Your Life : " + life);
	// 	System.out.println("Your strength : " + strength);
	// 	System.out.println("---");
	// 	System.out.println("Your Spell is " + monSpell.getNameSpell() + " who deliver " + monSpell.getSpellAttackLevel() + " damages.");
	// 	System.out.println("Your shield : " + shield);
	// 	System.out.println("Your inventory has " + inventory.size() + " Spells.");		
	// 	System.out.println("");
	// 	System.out.println("_________________________________________");
	// }


	public void ajouterSpellSpell(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Une Spell ? ");
		monSpell = new Spell();

		System.out.println("Son nom : ");
		String str1 = sc.nextLine();
		monSpell.setNameSpell(str1);

		System.out.println("Son niveau de puissance : ");
		int str2 = sc.nextInt();
		monSpell.setSpellAttackLevel(str2);
		inventory.add(monSpell);
	}

	public static void clearZone()
	{
		System.out.print("\033[H\033[2J");  //CLEAR TERMINAL
		System.out.flush();					//CLEAR TERMINAL
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
				System.out.println("|||||||||||||||||||||| INVENTAIRE DE "+ getName() +" ||||||||||||||||||||||");
				System.out.println("_____________________________________________________________________");
				System.out.println("---");
				System.out.println("Afficher l'inventaire ? = 1");
				System.out.println("Creer une Spell pour se battre et le noter dans l'inventaire ? = 2");
				System.out.println("Afficher l'Spell actuelle pour se battre ? = 3");
				System.out.println("Choisir l'Spell pour se battre ? = 4");
				System.out.println("Supprimer un objet de l'inventaire ? = 5");
				System.out.println("Quitter = 6");
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
						afficherInventory();
						break;        
					case "2":
						ajouterSpellSpell();			  
						break;        
					case "3":
						System.out.println(getName() + " utilise actuellement l'Spell : " + monSpell.getNameSpell());
						break;  
					case "4":
						selectionnerSpell();
						break;       
					case "5":
						supprimerSpell();
						break;   	
					case "6":
						quitter = true;
						break;   						  
					default:
						System.out.println("");
						break;        
				}
			}while(quitter != true);
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
			System.out.println("Voici l'Spell : " + inventory.get(i).getNameSpell() + " | Numero : " + i);
			System.out.println("Voici sa Puissance : " + inventory.get(i).getSpellAttackLevel());;
		}	

		// System.out.println("Your Spell is " + monSpell.getNameSpell() + " who deliver " + monSpell.getSpellAttackLevel() + " damages.");

	}

	public void selectionnerSpell()
	{
		Scanner sc = new Scanner(System.in);		
		afficherInventory();
		System.out.println("______________||QUELLE Spell VOULEZ VOUS UTILISER||______________");
		System.out.println("                     (Indiquez son numero)");
		int str2 = sc.nextInt();
		sc.nextLine();
		monSpell= inventory.get(str2);
		System.out.println(getName() + " utilise actuellement l'Spell : " + monSpell.getNameSpell());
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