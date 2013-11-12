package db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="Phone")
public class Phone {

	int id;
	String phone;
	int idPerson;


	@Id
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
 	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Column(name="phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String s) {
		this.phone = s;
	}

	@Column(name="idPerson")
	public int getIdPepson() {
		return idPerson;
	}

	public void setIdPepson(int idPerson) {
		this.idPerson = idPerson;
	}

}
