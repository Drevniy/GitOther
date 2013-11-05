package db;

import java.util.ArrayList;

public class FromDAO {
	public static void add(Person person) {
		DAO_MongoDB.add(person);
	}
	public static ArrayList<Person> read(Person person) {
		return DAO_MongoDB.read(person);
	}
	public static void update(Person person) {
		DAO_MongoDB.update(person);
	}
	public static void delete(int id) {
		DAO_MongoDB.delete(id);
	}
}
