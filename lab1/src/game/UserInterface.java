package game;

import javax.swing.JOptionPane;

public class UserInterface {
	
	public static void printMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int askForInt(String msg) {
		int nbr = Integer.parseInt(JOptionPane.showInputDialog(null, msg, "Information", JOptionPane.INFORMATION_MESSAGE));
		return nbr;
	}

}
