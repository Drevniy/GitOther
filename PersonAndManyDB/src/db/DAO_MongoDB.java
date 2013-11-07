package db;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class DAO_MongoDB{

	public static void add(Person person) throws UnknownHostException {
		MongoClient mongoClient = new MongoClient( "192.168.0.105" , 27017 );
		DB db = mongoClient.getDB( "db" );
		BasicDBObject doc = new BasicDBObject("id", person.getId()).
				append("firstName", person.firstName).
				append("lastName", person.lastName).
				append("age", person.age);

		DBCollection coll = db.getCollection("person");
		System.out.println("connect");

		coll.insert(doc);


		
	}

	public static ArrayList<Person> read(Person personIn) throws UnknownHostException {
		 ArrayList<Person> listPerson = new ArrayList<Person>();

		
		if(personIn == null){
		MongoClient mongoClient = new MongoClient( "192.168.0.105" , 27017 );
		DB db = mongoClient.getDB( "db" );
		DBCollection collection = db.getCollection("person");
		 DBCursor cursor =  collection.find();
		  
		  
		  while (cursor.hasNext()) {
		  
		   System.out.println(cursor.next());
		   
		   Person person = new Person();
		   person.setId( (int) cursor.curr().get("id"));
		   person.setFirstName((String) cursor.curr().get("firstName"));
		   person.setLastName((String) cursor.curr().get("lastName"));
		   person.setAge(Integer.parseInt((String) cursor.curr().get("age")));  
		   
		   listPerson.add(person);
		  }
		}
		return listPerson;
}

	public void update(Person person) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
