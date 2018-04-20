
package main.java.heroes.supriseBoxes.diverse;

import main.java.heroes.*;
import main.java.heroes.supriseBoxes.*;
import java.util.ArrayList;
import java.util.List;

public class BoxBonus extends Box {
	private int myTypeBonus = 0;
	public BoxBonus(int typeBonus) {
		super();
		myTypeBonus = typeBonus;
		nameEvent = "BONUS : " + myTypeBonus;
		
	}
	
	public void generateEvent() {
		switch(myTypeBonus)
		{           
			case 1:
				Dedale.myGame.getListeHeroes().get(0).setMySquare(Dedale.myGame.getListeHeroes().get(0).getMySquare() - 5);
				break;  
			case 2:
				Dedale.myGame.getListeHeroes().get(0).setMySquare(Dedale.myGame.getListeHeroes().get(0).getMySquare() + 5);
				break;       
			default:
				Dedale.myGame.getListeHeroes().get(0).setMySquare(Dedale.myGame.getListeHeroes().get(0).getMySquare() + 0);
				break; 
		}
		eventFinished = true;
	}

}