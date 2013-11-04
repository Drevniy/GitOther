package db;



import java.awt.BorderLayout;

import javax.swing.JFrame;


public class BasicFrame extends JFrame
{
	public BasicFrame()
	{
		setBounds(320, 200, 600, 450);
		
		
		//add(new PanelTable());
		add(new PanelSearch(),BorderLayout.NORTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
