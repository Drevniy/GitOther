package db;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;


public class BasicFrame extends JFrame
{
	public BasicFrame()
	{
		setBounds(320, 200, 600, 450);
		
		JTable table = new JTable();
		ModelTable modelTable = new ModelTable(table);
		//TableRowSorter<ModelTable> sorter = new TableRowSorter<ModelTable> (modelTable);
		add(new PanelSearch(modelTable),BorderLayout.NORTH);
		
		table.setModel(modelTable);
		//table.setRowSorter(sorter);
		
		JScrollPane scroll = new JScrollPane(table);
		add(scroll,BorderLayout.CENTER);
		
		add(new PanelButtons(table,modelTable.getListPerson()), BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
