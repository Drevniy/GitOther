package db;

import java.util.ArrayList;

public interface DAO {
	
	public void add(Person person);
	public ArrayList<Person> read(Person person);
	public void update(Person person);
	public void delete(int id);
}
