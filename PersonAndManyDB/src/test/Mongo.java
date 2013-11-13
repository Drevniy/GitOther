package test;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import db.Address;
import db.DAO_MongoDB;
import db.FromDAO;
import db.Person;
import db.Phone;

public class Mongo {

	
	public void test() throws UnknownHostException {
		Person person = new Person();
		
		person.setId(123);
		person.setFirstName("test");
		person.setLastName("test");
		person.setAge(33);
		
		DAO_MongoDB.add(person);
	}
	
	@Test
	public void test1() throws UnknownHostException, ClassNotFoundException, SQLException {
		
		Person person = new Person();
		Address address = new Address();
		Phone phone = new Phone();
		
		ArrayList<Address> addressList = new ArrayList<>();
		ArrayList<Phone> phoneList = new ArrayList<>();
		
		addressList.add(address);
		phoneList.add(phone);
		
		address.setAdress("nnnn");
		address.setPerson(person);
		phone.setPhone("123456789");
		phone.setPerson(person);
		person.setFirstName("test");
		person.setLastName("test");
		person.setAge(38);
		person.setAddressList(addressList);
		person.setPhoneList(phoneList);
		
		FromDAO.add(person);
	}
}
