package game;

import java.util.Random;

public class TakePinsGame {

	public static void main(String[] args) {
		Player p1 = new HumanPlayer("Du");
		Player p2 = new SmartComputerPlayer("Datorn");
		Random rand = new Random();
		Board spelPlan = new Board(rand.nextInt(5)+18);
		
		spelPlan.setUp(spelPlan.getNbrPins());
		while (spelPlan.getNbrPins() > 0) {
			UserInterface.printMessage("Nu är det din tur!");
			p1.takePins(spelPlan);
			
			if(spelPlan.getNbrPins()<1) {
				break;
			}
			
			UserInterface.printMessage("Nu är det datorns tur!");
			p2.takePins(spelPlan);
		}
		UserInterface.printMessage("Spelet är slut!");

	}

}
