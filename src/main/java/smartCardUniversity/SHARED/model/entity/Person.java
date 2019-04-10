
package smartCardUniversity.SHARED.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	
	@Id
	@Column(name = "person_id", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name", length = 60, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 60, nullable = false)
	private String lastName;
	
	@Column(name = "birth_date", length = 60, nullable = false)
	private Date birthDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", nullable = false)
	private Address personAddress;
	
	@Column(name = "phone_number", length = 60, nullable = false, unique = true)
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name = "gender_id", nullable = false)
	private Gender personGender;
	//
	@OneToOne(mappedBy = "person")
	private AppUser appUser;
	
	public Person() 
	{
		
	}
	
	public Person(Integer id, String firstName, String lastName, Date birthDate, Address personAddress,
			String phoneNumber, Gender personGender, AppUser appUser) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.personAddress = personAddress;
		this.phoneNumber = phoneNumber;
		this.personGender = personGender;
		this.appUser = appUser;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Address getPersonAddress() {
		return personAddress;
	}
	public void setPersonAddress(Address personAddress) {
		this.personAddress = personAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Gender getPersonGender() {
		return personGender;
	}
	public void setPersonGender(Gender personGender) {
		this.personGender = personGender;
	}
	public AppUser getAppUser() {
		return appUser;
	}
	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", personAddress=" + personAddress + ", phoneNumber=" + phoneNumber + ", personGender=" + personGender;
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
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
