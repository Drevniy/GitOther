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
@Table(name="Address")
public class Address {
	
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
	private int id;
	
	@Column(name="streetName")
	private String adress;
	
	@Column(name="idPerson")
	private int idPepson;
	
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getIdPepson() {
		return idPepson;
	}

	public void setIdPepson(int idPepson) {
		this.idPepson = idPepson;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}

