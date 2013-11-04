package db;



import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class BasicFrame extends JFrame
{
	public BasicFrame()
	{
		setBounds(320, 200, 600, 450);
		
		
		//add(new PanelTable());
		add(new PanelSearch(),BorderLayout.NORTH);
		
		JTable table = new JTable(new ModelTable());
		
		JScrollPane scroll = new JScrollPane(table);
		//scroll.setPreferredSize(new Dimension(600, 350));
		add(scroll,BorderLayout.CENTER);
		
		add(new PanelButtons(), BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
