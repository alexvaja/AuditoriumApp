package smartCardUniversity.SHARED.model.entity;

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
	@Column(name = "address_id", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "street", length = 120, nullable = false)
	private String street;
	
	@Column(name = "city", length = 60, nullable = false)
	private String city;
	// 
	@OneToOne(mappedBy = "personAddress")
	private Person person;
	
	@OneToOne(mappedBy = "universityAddress")
	private University university;
	
	@OneToOne(mappedBy = "corpAddress")
 	private Corp corp;
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city;
	}
	
	
	public Address()
	{
		super();
	}
	public Address(Integer id, String street, String city, Person person, University university, Corp corp) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.person = person;
		this.university = university;
		this.corp = corp;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public Corp getCorp() {
		return corp;
	}
	public void setCorp(Corp corp) {
		this.corp = corp;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
