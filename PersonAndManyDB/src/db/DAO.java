package db;

import java.util.ArrayList;
import java.util.List;


public interface DAO {
	
	public void add(Person person);
	public List<Person> read(Person person);
	public void update(Person person);
	public void delete(Person person);
}
