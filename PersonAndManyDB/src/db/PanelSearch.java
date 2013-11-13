package db;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelSearch extends JPanel{
	JTextField txtFirstName;
	JTextField txtLastName;
	JTextField txtAge;
	ModelTable modelTable;
	
	
	public PanelSearch(final ModelTable modelTable) {
		this.modelTable = modelTable;
		
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
		
		txtFirstName = new JTextField("");
		txtLastName = new JTextField("");
		txtAge = new JTextField("");
		
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
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtFirstName.getText().equals("")&&txtLastName.getText().equals("")
						&&txtAge.getText().equals("")){
					
					List<Person> listPerson= FromDAO.read(null);
					modelTable.setListPerson(listPerson);
				}else{
					Person person = new Person();
					person.setFirstName(txtFirstName.getText());
					person.setLastName(txtLastName.getText());
					if(txtAge.getText().equals("")){
					}else{
						person.setAge(Integer.parseInt(txtAge.getText()));
					}
					
					List<Person> listPerson= FromDAO.read(person);
					modelTable.setListPerson(listPerson);
				}
				
			}
		});
	}

}
