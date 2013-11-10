package db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Person")
public class Person {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String streetName;
	private int phoneMobile;
	
	public Person() {
		id = 0;
		firstName = "";
		lastName = "";
		age = 0;
		streetName = "";
		phoneMobile = 0;
		
		
	}

	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="firstname")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="lastname")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getPhoneMobile() {
		return phoneMobile;
	}

	public void setPhoneMobile(int phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	
	
	
	
}
