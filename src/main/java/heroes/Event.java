package main.java.heroes;
import main.java.heroes.enemy.*;

public class Event {
	protected static int type = 0;
	protected static int typeEnnemi = 0;
	protected static int typeCaisse = 0;
	public Enemy myEnemy = new Enemy();

	public Event() {
		
	}
	
	
	
	public void setEnemy(Enemy theEnemy){
		myEnemy = theEnemy;
	}
}
