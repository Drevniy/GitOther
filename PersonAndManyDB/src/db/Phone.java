package db;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="Phone")
public class Phone {

	@Column(name="id")
	int id;
	
	@Column(name="person_id")
	int person_id;

	@Column(name="phone")
	String phone;

	public Phone() {

	}

    
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

}
