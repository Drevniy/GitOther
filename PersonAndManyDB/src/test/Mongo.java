package test;

import java.awt.Dimension;
import java.net.UnknownHostException;

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
	public void test1() throws UnknownHostException {
		
		DAO_MongoDB.read();
	}
	
}
