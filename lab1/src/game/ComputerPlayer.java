package game;

import java.util.Random;

public class ComputerPlayer extends Player {

	public ComputerPlayer(String userId) {
		super(userId);
	}

	public void computerPlayer() { 
		UserInterface.printMessage("Datorns tur!");
	}
	
	public int takePins(Board spel) {
		Random rand = new Random();
		int alternativ = (rand.nextInt(2) + 1);
		UserInterface.printMessage("Datorn tog " + alternativ + "st stickor!");
		spel.takePins(alternativ);
		return alternativ;
	}
}