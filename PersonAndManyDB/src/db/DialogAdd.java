package db;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogAdd extends JDialog implements ActionListener
{
	private int res = -1;
	private JTextField textMobile;
	private JTextField textHome;
	private JTextField textWork;
	
	public DialogAdd(JFrame frame)
	{
		super(frame, true);
		setSize(200, 150);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(4, 2));
		setLocationRelativeTo(frame);
		
		JLabel lblMobile = new JLabel("Mobile:");
		JLabel lblHome = new JLabel("Home:");
		JLabel lblWork = new JLabel("Work:");
		
		JButton btnOk = new JButton("Ok");
		JButton btnCancel = new JButton("Cancel");
		
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		
		textMobile = new JTextField("");
		textHome = new JTextField("");
		textWork = new JTextField("");
		
		add(lblMobile);
		add(textMobile);
		add(lblHome);
		add(textHome);
		add(lblWork);
		add(textWork);
		add(btnOk);
		add(btnCancel);
		
		
	}
	
	
	public int showDialog(String[] phones)
	{
		textMobile.setText(phones[0]);
		textHome.setText(phones[1]);
		textWork.setText(phones[2]);
		
		setVisible(true);
		return res;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton btn = (JButton) e.getSource();
		
		if(btn.getText().equals("Ok"))
		{
			res = 0;
			dispose();
		}
		else
		{
			res = 1;
			dispose();
		}
	}


	public String getTextMobile() {
		return textMobile.getText();
	}


	public void setTextMobile(JTextField textMobile) {
		this.textMobile = textMobile;
	}


	public String getTextHome() {
		return textHome.getText();
	}


	public void setTextHome(JTextField textHome) {
		this.textHome = textHome;
	}


	public String getTextWork() {
		return textWork.getText();
	}


	public void setTextWork(JTextField textWork) {
		this.textWork = textWork;
	}
	
}
