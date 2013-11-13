package db;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class FromDAO {
	public static void add(Person person) {
		//DAO_MongoDB.add(person);
		FactoryDAO.getDaoHibernate().add(person);
	}
	public static List<Person> read(Person person) {
		//return DAO_MongoDB.read(person);
		return FactoryDAO.getDaoHibernate().read(person);

	}
	public static void update(Person person) {
		//DAO_MongoDB.update(person);
		FactoryDAO.getDaoHibernate().update(person);

	}
	public static void delete(int id) {
		//DAO_MongoDB.delete(id);
		FactoryDAO.getDaoHibernate().delete(id);

	}
}
