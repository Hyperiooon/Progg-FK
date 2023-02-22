package game;

public class Board { //Abstract?
	protected int nbrPins; //Ska det vara protected?

	public Board(int nbrPins) {
		this.nbrPins = nbrPins;
	}
	
	public void setUp(int startNbr) { 
		UserInterface.printMessage("Välkommen till spelet, spelplanen består av: " + startNbr + "st stickor!");
	
	}
	
	public int takePins(int takeNbr) { //Gatekeepers?
		nbrPins -= takeNbr;
		UserInterface.printMessage(nbrPins + "st stickor finns kvar!");
		return nbrPins;
	}
	
	public int getNbrPins() {
		//System.out.println(nbrPins + "st stickor finns kvar!");
		return nbrPins;
	}
}
