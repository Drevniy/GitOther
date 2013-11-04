package db;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelSearch extends JPanel{
	
	public PanelSearch() {
		GridLayout gridLayout = new GridLayout(2, 5);
		gridLayout.setHgap(5);
		gridLayout.setVgap(5);
		setLayout(gridLayout);
		
		JLabel lblFirstName = new JLabel("First Name:");
		JLabel lblLastName = new JLabel("Last Name:");
		JLabel lblAge = new JLabel("Age:");
		
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblEmpty1 = new JLabel();
		JLabel lblEmpty2 = new JLabel();
		JLabel lblEmpty3 = new JLabel();
		
		JButton btnSearch = new JButton("Search");
		
		JTextField txtFirstName = new JTextField("");
		JTextField txtLastName = new JTextField("");
		JTextField txtAge = new JTextField("");
		
		add(lblFirstName);
		add(txtFirstName);
		add(lblAge);
		add(txtAge);
		add(lblEmpty1);
		add(lblLastName);
		add(txtLastName);
		add(lblEmpty2);
		add(lblEmpty3);
		add(btnSearch);
	}

}
