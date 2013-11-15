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
	private JTextField txtAddress;
	private JTextField txtPhone;
	
	public DialogAddOrUpdate(JFrame frame, String title)
	{
		super(frame, true);
		setSize(200, 180);
		setTitle(title);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(6, 2));
		setLocationRelativeTo(frame);
		
		JLabel lblFirstName = new JLabel("First Name:");
		JLabel lblLastName = new JLabel("Last Name:");
		JLabel lblAge = new JLabel("Age:");
		JLabel lblAddress = new JLabel("Address:");
		JLabel lblPhone = new JLabel("Phone:");
		
		JButton btnOk = new JButton("Ok");
		JButton btnCancel = new JButton("Cancel");
		
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		
		txtFirstName = new JTextField("");
		txtLastName = new JTextField("");
		txtAge = new JTextField("");
		txtAddress = new JTextField("");
		txtPhone = new JTextField("");
		
		add(lblFirstName);
		add(txtFirstName);
		add(lblLastName);
		add(txtLastName);
		add(lblAge);
		add(txtAge);
		add(lblAddress);
		add(txtAddress);
		add(lblPhone);
		add(txtPhone);
		
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

	public String getAddress() {
		return txtAddress.getText();
	}

	public void setTxtAddress(String address) {
		this.txtAddress.setText(address);
	}

	public String getPhone() {
		return txtPhone.getText();
	}

	public void setPhone(String phone) {
		this.txtPhone.setText(phone);
	}
	
	
	
}
