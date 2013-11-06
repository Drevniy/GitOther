package db;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogAddOrUpdate extends JDialog implements ActionListener
{
	private int res = -1;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAge;
	
	public DialogAddOrUpdate(JFrame frame, String title)
	{
		super(frame, true);
		setSize(200, 150);
		setTitle(title);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(4, 2));
		setLocationRelativeTo(frame);
		
		JLabel lblFirstName = new JLabel("First Name:");
		JLabel lblLastName = new JLabel("Last Name:");
		JLabel lblAge = new JLabel("Age:");
		
		JButton btnOk = new JButton("Ok");
		JButton btnCancel = new JButton("Cancel");
		
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		
		txtFirstName = new JTextField("");
		txtLastName = new JTextField("");
		txtAge = new JTextField("");
		
		add(lblFirstName);
		add(txtFirstName);
		add(lblLastName);
		add(txtLastName);
		add(lblAge);
		add(txtAge);
		add(btnOk);
		add(btnCancel);
		
		
	}
	
	
	public int showDialog()
	{
		setVisible(true);
		return res;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton btn = (JButton) e.getSource();
		
		if(btn.getText().equals("Ok"))
		{
			res = 1;
			dispose();
		}
		else
		{
			res = 0;
			dispose();
		}
	}


	public String getFirstName() {
		return txtFirstName.getText();
	}

	public void setFirstName(String firstName) {
		this.txtFirstName.setText(firstName);
	}

	public String getLastName() {
		return txtLastName.getText();
	}

	public void setLastName(String lLastName) {
		this.txtLastName.setText(lLastName);
	}

	public String getAge() {
		return txtAge.getText();
	}

	public void setAge(String age) {
		this.txtAge.setText(age);
	}
	
}
