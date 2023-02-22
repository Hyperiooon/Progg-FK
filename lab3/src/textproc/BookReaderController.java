package textproc;

import java.awt.Container;
import java.awt.Dimension;
import java.util.Map;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class BookReaderController {
	public BookReaderController(GeneralWordCounter counter) {
		SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
	}

	private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();

		SortedListModel<Map.Entry<String,Integer>> listModel = new SortedListModel<>(counter.getWordList());

		JList<Map.Entry<String,Integer>> listView = new JList<>(listModel); // Importerat
		/**listView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listView.addListSelectionListener(event -> {
			label.setText((listView.getSelectedIndex()) + ": " + (listView.getSelectedValue()));
		});*/

		JScrollPane scrollPane = new JScrollPane(listView);
		scrollPane.setPreferredSize(new Dimension(200, 100));
		scrollPane.setBorder(new EmptyBorder(5, 10, 5, 10));
		
		JPanel southPanel = new JPanel();
		JButton alpha = new JButton("Alphabetical");
		alpha.addActionListener(event -> listModel.sort((a,b)-> a.getKey().compareTo(b.getKey())));
		
		JButton freq = new JButton("Frequency");
		freq.addActionListener(event -> listModel.sort((a,b) -> b.getValue().compareTo(a.getValue())));
		
		JButton find = new JButton("Find");
		JTextField skriv = new JTextField("Sökord:");
		frame.getRootPane().setDefaultButton(find);
		
		pane.add(scrollPane, BorderLayout.SOUTH);
		southPanel.add(alpha);
		southPanel.add(freq);
		southPanel.add(find);
		southPanel.add(skriv);
		pane.add(southPanel, BorderLayout.SOUTH);
		
		find.addActionListener(e -> {
			String ord = skriv.getText().replaceAll(" ", "").toLowerCase();
			skriv.setText("");
			boolean finns = false;
			
			for(int i = 0; i < listModel.getSize(); i++) {
				if(listModel.getElementAt(i).getKey().compareTo(ord)==0) {
					listView.ensureIndexIsVisible(i);
					listView.setSelectedIndex(i);
					finns = true;
					break;
					
				}
			}
			if(!finns) {
				JOptionPane.showMessageDialog(pane, ord + " finns inte");
			}
		});
		
		
		
		//pane.add(label, BorderLayout.SOUTH);
		


		frame.pack();
		frame.setVisible(true);

	}
}
