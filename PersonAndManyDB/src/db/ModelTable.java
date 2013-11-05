package db;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


public class ModelTable implements TableModel 
{
	
	private ArrayList<Person> listPerson;
	
	public ModelTable() {
		this.listPerson = FromDAO.read(null);
	}
	
	@Override
	public int getRowCount() {
		return listPerson.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String res = "";
		switch (columnIndex) {
			case 0:
				res = "id";
				break;
			case 1:
				res = "First Name";
				break;
			case 2:
				res = "LastName";
				break;
			case 3:
				res = "Age";
				break;
	
			default:
				break;
		}
		return res;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return "".getClass();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		boolean res = false;
		if(columnIndex==1||columnIndex==2||columnIndex==3){
			res = true;
		}
		return res;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object res = null;
		Person person = listPerson.get(rowIndex);
		switch (columnIndex) {
			case 0:
				res = person.getId();
				break;
			case 1:
				res = person.getFirstName();
				break;
			case 2:
				res = person.getLastName();
				break;
			case 3:
				res = person.getAge();
				break;
	
			default:
				break;
		}
		return res;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Person person = listPerson.get(rowIndex);
		switch (columnIndex) {
			case 0:
				person.setId(Integer.parseInt((String) aValue));
				break;
			case 1:
				person.setFirstName((String) aValue);
				break;
			case 2:
				person.setLastName((String) aValue);
				break;
			case 3:
				person.setAge(Integer.parseInt((String) aValue));
				break;
	
			default:
				break;
		}
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
