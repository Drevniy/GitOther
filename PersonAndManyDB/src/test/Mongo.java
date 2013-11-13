package test;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import db.DAO_MongoDB;
import db.FromDAO;
import db.Person;

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
		
		List<Person> list = FromDAO.read(null);
		System.out.println(list.get(0).getFirstName()+" "+list.get(0).getAddressList().get(0).getAdress());
	}
	
}
