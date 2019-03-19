package auditorium.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@Column(name = "address_id", length = 25, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "address", length = 120, nullable = false)
	private String address;
	
	@Column(name = "city", length = 60, nullable = false)
	private String city;
	// 
	@OneToOne(mappedBy = "personAddress")
	private Person person;
	
	@OneToOne(mappedBy = "universityAddress")
	private University university;
	
//	@OneToOne(mappedBy = "address")
//	private Corp cord;
	
	public Address() {
		super();
	}

	public Address(Integer id, String address, String city) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", city=" + city + ", person=" + person + ", university="
				+ university + "]";
	}
}
