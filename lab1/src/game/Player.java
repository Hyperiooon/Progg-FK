package game;

public abstract class Player {
	protected String userId;
	
	protected Player(String userId) {
		this.userId = userId;
	}
	
	public void player(String text) {
	}
	
	public String getUserId() {
		UserInterface.printMessage("Spelare " + userId);
		return userId;
	}
	
	public abstract int takePins(Board plan);
}
