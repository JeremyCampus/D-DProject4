
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
				Dedale.setmySquare(Dedale.getmySquare()-5);
				break;  
			case 2:
				Dedale.setmySquare(Dedale.getmySquare()+5);
				break;       
			default:
				Dedale.setmySquare(Dedale.getmySquare()+0);
				break; 
		}
		eventFinished = true;
	}

}