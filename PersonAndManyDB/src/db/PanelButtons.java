package db;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class PanelButtons extends JPanel {
	JTable table;
	List<Person> listPerson;
	
	public PanelButtons(final JTable table,final List<Person> listPerson) {
		this.table = table;
		this.listPerson = listPerson;
		
		JButton btnAdd = new JButton("add");
		JButton btnUpdate = new JButton("edit");
		JButton btnDelete = new JButton("delete");
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Person person = listPerson.get(table.getSelectedRow());
				FromDAO.delete(person);
				
				listPerson.remove(table.getSelectedRow());
				table.revalidate();
				table.repaint();
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogAddOrUpdate dialog = new DialogAddOrUpdate((JFrame) PanelButtons.this.getParent().getParent().getParent().getParent(), "add");
				if(dialog.showDialog()==1){
					Person person = new Person();
					person.setFirstName(dialog.getFirstName());
					person.setLastName(dialog.getLastName());
					person.setAge(Integer.parseInt(dialog.getAge()));
					
					Address address = new Address();
					Phone phone = new Phone();

					address.setPerson(person);
					address.setAdress(dialog.getAddress());
					
					phone.setPerson(person);
					phone.setPhone(dialog.getPhone());
					
					ArrayList<Address> addressList = new ArrayList<>();
					ArrayList<Phone> phoneList = new ArrayList<>();
					
					addressList.add(address);
					phoneList.add(phone);
					
					person.setAddressList(addressList);
					person.setPhoneList(phoneList);
					
					/*int res = 0;
					for (int i = 0; i < listPerson.size(); i++) {
						if(listPerson.get(i).getId()>res){
							res = listPerson.get(i).getId();
						}
					}
					person.setId(res+1);*/
					
					FromDAO.add(person);
					listPerson.add(person);
					table.revalidate();
					table.repaint();
					
				}else{
				}
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Person person = listPerson.get(table.getSelectedRow());
				DialogAddOrUpdate dialog = new DialogAddOrUpdate((JFrame) PanelButtons.this.getParent().getParent().getParent().getParent(), "edit");
				dialog.setFirstName(person.getFirstName());
				dialog.setLastName(person.getLastName());
				dialog.setAge(person.getAge()+"");
				
				if(dialog.showDialog()==1){
					person.setFirstName(dialog.getFirstName());
					person.setLastName(dialog.getLastName());
					person.setAge(Integer.parseInt(dialog.getAge()));
					
					FromDAO.update(person);
					table.revalidate();
					table.repaint();
					
				}else{
				}
			}
		});
		
		add(btnAdd);
		add(btnUpdate);
		add(btnDelete);
	
	}

}
