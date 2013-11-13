package db;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="Phone")
public class Phone {

	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
	private int id;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="idPerson")
	private int idPerson;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinTable(
            name="person",
            joinColumns = @JoinColumn( name="id"),
            inverseJoinColumns = @JoinColumn( name="idperson")
    )
	private Person person;
	
 	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String s) {
		this.phone = s;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
