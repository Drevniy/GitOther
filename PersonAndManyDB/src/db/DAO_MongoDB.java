package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAO_MongoDB {

	public static void add(Person person) {
		System.out.println("add");
		
	}

	public static ArrayList<Person> read(Person person) {
		 ArrayList<Person> personList =  new  ArrayList<>();
		
		if(person == null){
			try {
				Class.forName("org.h2.Driver");
				Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		        
		        Statement st = conn.createStatement();
		        ResultSet result;
		        result = st.executeQuery("select * from person");
		        
		        while (result.next())
		        {
		        	Person personNew = new Person(); 
		        	
		        	personNew.setId(result.getInt("ID"));
		        	personNew.setFirstName(result.getString("FIRSTNAME"));
		        	personNew.setLastName(result.getString("LASTNAME"));
		        	personNew.setAge(result.getInt("AGE"));
		        	personList.add(personNew);
		        }
		        st.close();
		        conn.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			System.out.println("read");
		}
		
		
		return personList;
	}

	public static void update(Person person) {
		System.out.println("update");
		
	}

	public static void delete(int id) {
		System.out.println("delete");
		
	}

}
