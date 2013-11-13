package db;

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
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
	private int id;
	
	@Column(name="streetName")
	private String adress;
	
	@Column(name="idPepson")
	private int idPepson;
	
	//@ManyToOne
	//@JoinTable(name = "id")
	//private Person person;
	
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

/*	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	*/
	

}

