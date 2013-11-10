package db;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class DAO_MongoDB{

	public static void add(Person person) {
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient( "127.0.0.1" , 27017 );
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB db = mongoClient.getDB( "db" );
		DBCollection coll = db.getCollection("person");
		
		BasicDBObject doc = new BasicDBObject("_id",person.getId()).
				append("firstName", person.getFirstName()).
				append("lastName", person.getLastName()).
				append("age", person.getAge());
		
		coll.insert(doc);


		
	}

	public static ArrayList<Person> read(Person personIn){
		
		 ArrayList<Person> listPerson = new ArrayList<Person>();
		
		if(personIn == null){
		try {
			MongoClient mongoClient = new MongoClient( "127.0.0.1" , 27017 );
			DB db = mongoClient.getDB( "db" );
			DBCollection collection = db.getCollection("person");
			
			 DBCursor cursor =  collection.find();
			 while (cursor.hasNext()) {
				 	cursor.next();
				   Person person = new Person();
				   person.setId( (int) cursor.curr().get("_id"));
				   person.setFirstName((String) cursor.curr().get("firstName"));
				   person.setLastName((String) cursor.curr().get("lastName"));
				   person.setAge((int) cursor.curr().get("age"));  
				   
				   listPerson.add(person);
				  }
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		}else{
			try {
				MongoClient mongoClient = new MongoClient( "127.0.0.1" , 27017 );
				DB db = mongoClient.getDB( "db" );
				DBCollection collection = db.getCollection("person");
				
				 DBCursor cursor =  collection.find(docForQuery(personIn));
				 while (cursor.hasNext()) {
					 	cursor.next();
					   Person person = new Person();
					   person.setId( (int) cursor.curr().get("_id"));
					   person.setFirstName((String) cursor.curr().get("firstName"));
					   person.setLastName((String) cursor.curr().get("lastName"));
					   person.setAge((int) cursor.curr().get("age"));  
					   
					   listPerson.add(person);
					  }
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return listPerson;
}

	public static void update(Person person) {
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient( "127.0.0.1" , 27017 );
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB db = mongoClient.getDB( "db" );
		DBCollection coll = db.getCollection("person");
		
		BasicDBObject doc = new BasicDBObject("_id",person.getId()).
				append("firstName", person.getFirstName()).
				append("lastName", person.getLastName()).
				append("age", person.getAge());
		
		BasicDBObject docOld = new BasicDBObject("_id",person.getId());
		
		coll.update(coll.findOne(docOld), doc);
		
	}

	public static void delete(int id) {
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient( "127.0.0.1" , 27017 );
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB db = mongoClient.getDB( "db" );
		DBCollection coll = db.getCollection("person");
		
		BasicDBObject doc = new BasicDBObject("_id",id);
		
		coll.remove(doc);
		
	}
	
	private static BasicDBObject docForQuery(Person person){
		
		BasicDBObject docQuery = new BasicDBObject();
		
		if( !person.getFirstName().equals("")){
			docQuery.append("firstName", person.getFirstName());
		}
		if(!person.getLastName().equals("")){
			docQuery.append("lastName", person.getLastName());
		}
		if(person.getAge()!=0){
			docQuery.append("age", person.getAge());
		}
		
		return docQuery;
		
	}

}
