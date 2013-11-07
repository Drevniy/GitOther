package db;

import java.net.UnknownHostException;
import java.util.ArrayList;

public class FromDAO {
	public static void add(Person person) throws UnknownHostException {
		DAO_MongoDB.add(person);
	}
	public static ArrayList<Person> read(Person person) throws UnknownHostException {
		return DAO_MongoDB.read(person);
	}
	public static void update(Person person) {
		DAO_H2.update(person);
	}
	public static void delete(int id) {
		DAO_H2.delete(id);
	}
}
