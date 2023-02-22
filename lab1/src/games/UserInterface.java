package games;

import javax.swing.JOptionPane;

public class UserInterface {
	
	public static void printMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int askForInt(String msg) {
		String s = JOptionPane.showInputDialog(null, msg, "Information", JOptionPane.INFORMATION_MESSAGE);
		if (s == null) {
			return -2;
		}
		else {
			int nbr;
			try {
				nbr = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				return -1;
			}
			return nbr;
		}
		
	}

}
