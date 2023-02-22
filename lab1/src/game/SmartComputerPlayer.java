package game;

public class SmartComputerPlayer extends Player{
	
	public SmartComputerPlayer (String userId) {
		super (userId);
	}
	
	public int takePins(Board spel) {
		if (spel.getNbrPins() == 1) {
			UserInterface.printMessage("Datorn tog 1 st sticka!");
			spel.takePins(1);
			return 1;
		}
		else if (spel.getNbrPins() == 2) {
			UserInterface.printMessage("Datorn tog 2 st stickor!");
			spel.takePins(2);	
			return 2;
		}
		else if(spel.getNbrPins()%2 == 1) {
			UserInterface.printMessage("Datorn tog 2 st stickor!");
			spel.takePins(2);	
			return 2;
		}
		else {
			UserInterface.printMessage("Datorn tog 1 st sticka!");
			spel.takePins(1);
			return 1;
		}
	}
	
	

}
