package db;

import java.util.ArrayList;

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
	private ArrayList<Address> addressList;
	private ArrayList<Phone> phoneList;
	
	public Person() {
		id = 0;
		firstName = "";
		lastName = "";
		age = 0;
		addressList = null;
		phoneList = null;
	}

	@Id
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

	public ArrayList<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(ArrayList<Address> addressList) {
		this.addressList = addressList;
	}

	public ArrayList<Phone> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(ArrayList<Phone> phoneList) {
		this.phoneList = phoneList;
	}
	
	
}
