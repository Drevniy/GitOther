package db;
import java.io.File;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


public class ModelTable implements TableModel 
{
	private List<Person> listPerson;
	JTable table;
	
	public ModelTable(JTable table) {
		this.table = table;
		
			this.listPerson = FromDAO.read(null);
	}
	
	@Override
	public int getRowCount() {
		return listPerson.size();
	}

	@Override
	public int getColumnCount() {
		return 6;
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
			case 4:
				res = "StreetName";
				break;
			case 5:
				res = "PhoneNumber";
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
		boolean res = true;
		if(columnIndex==0){
			res = false;
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
			case 4:
				if(person.getAddressList().size()==0){
					res="";
				}
				else{
					res = person.getAddressList().get(0).getAdress();
				}
				break;
			case 5:
				if(person.getPhoneList().size()==0){
					res="";
				}
				else{
					res = person.getPhoneList().get(0).getPhone();
				}
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
			case 4:
				if(person.getAddressList().size()==0){
					Address address = new Address();
					address.setAdress((String) aValue);
					person.getAddressList().add(address);
				}
				else{
					person.getAddressList().get(0).setAdress((String) aValue);
				}
				
				break;
			case 5:
				if(person.getPhoneList().size()==0){
					Phone phone = new Phone();
					phone.setPhone((String) aValue);
					person.getPhoneList().add(phone);
				}
				else{
					person.getPhoneList().get(0).setPhone((String) aValue);
				}
				
				break;
				
			default:
				break;
		}
		FromDAO.update(person);
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Person> getListPerson() {
		return listPerson;
	}
	
	public void setListPerson(List<Person> listPerson) {
		this.listPerson = listPerson;
		table.revalidate();
	}

}
