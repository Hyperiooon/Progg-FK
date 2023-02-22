package games;

public class HumanPlayer extends Player {

	public HumanPlayer(String userId) {
		super(userId);
	}

	public void humanPlayer() {
		UserInterface.printMessage("Din tur!");
	}

	public int takePins(Board spel) {
		int alternativ = 3;
		while ((0 > alternativ) || (alternativ > 2)) {
			alternativ = UserInterface.askForInt("Vill du ta en eller två stickor?");
			if (alternativ == -2) {
				UserInterface.printMessage("Spelet stängs!");
				System.exit(0);
			}
			else if (alternativ == -1) {
				UserInterface.printMessage("Ogilitigt alternativ, skriv in siffran 1 eller 2!");
			}
			else if ((0 > alternativ) || (alternativ > 2)) {
				UserInterface.printMessage("Ogilitigt alternativ, skriv in siffran 1 eller 2!");
			}
		}
		spel.takePins(alternativ);
		return alternativ;
	}

}
