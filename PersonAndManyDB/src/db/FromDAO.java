package db;

import java.net.UnknownHostException;
import java.util.ArrayList;

public class FromDAO {
	public static void add(Person person) {
		//DAO_MongoDB.add(person);
		DAO_MySQL_Hibernate.add(person);
	}
	public static ArrayList<Person> read(Person person) {
		//return DAO_MongoDB.read(person);
		return DAO_MySQL_Hibernate.read(person);

	}
	public static void update(Person person) {
		//DAO_MongoDB.update(person);
		DAO_MySQL_Hibernate.update(person);

	}
	public static void delete(int id) {
		//DAO_MongoDB.delete(id);
		DAO_MySQL_Hibernate.delete(id);

	}
}
