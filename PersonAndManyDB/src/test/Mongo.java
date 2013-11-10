package test;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import db.DAO_MongoDB;
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
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","sqluser", "sqluser");
		conn.close();
	}
	
}
