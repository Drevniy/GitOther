package db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Person")
public class Person {
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
	private int id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="age")
	private int age;
	
	@OneToMany(cascade=CascadeType.ALL)
	 @JoinTable(
	            name="address",
	            joinColumns = @JoinColumn( name="idperson"),
	            inverseJoinColumns = @JoinColumn( name="id")
	    )
	private List<Address> addressList = null ;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(
            name="phone",
            joinColumns = @JoinColumn( name="idperson"),
            inverseJoinColumns = @JoinColumn( name="id")
    )
	private List<Phone> phoneList = null;
	
	public Person() {
		id = 0;
		firstName = "";
		lastName = "";
		age = 0;
		addressList = null;
		phoneList = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

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

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(ArrayList<Address> addressList) {
		this.addressList = addressList;
	}

	public List<Phone> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(ArrayList<Phone> phoneList) {
		this.phoneList = phoneList;
	}
	
	
}
