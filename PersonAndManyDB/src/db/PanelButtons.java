package db;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelButtons extends JPanel {
	
	public PanelButtons() {

		JButton btnAdd = new JButton("add");
		JButton btnUpdate = new JButton("update");
		JButton btnDelete = new JButton("delete");
		
		add(btnAdd);
		add(btnUpdate);
		add(btnDelete);
	
	}

}
