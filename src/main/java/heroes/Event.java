package main.java.heroes;
import java.util.Random;

public class Event {
	protected int test = 1;
	public Event() {
		test =  + (int)(Math.random() * ((100 - 1) + 1));;
	}
	
	public int getTest(){
		return test;
	}
}
