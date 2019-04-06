package smartCardUniversity.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "university")
public class University {

	@Id
	@Column(name = "university_id", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", length = 60, nullable = false, unique = true)
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", nullable = false, unique = true)
	private Address universityAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "abbreviation_id", nullable = false, unique = true)
	private Abbreviation universityAbbreviation;
	//
	@OneToOne(mappedBy = "university")
	private College college;
	public University(Integer id, String name, Address universityAddress, Abbreviation universityAbbreviation,
			College college) {
		super();
		this.id = id;
		this.name = name;
		this.universityAddress = universityAddress;
		this.universityAbbreviation = universityAbbreviation;
		this.college = college;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getUniversityAddress() {
		return universityAddress;
	}
	public void setUniversityAddress(Address universityAddress) {
		this.universityAddress = universityAddress;
	}
	public Abbreviation getUniversityAbbreviation() {
		return universityAbbreviation;
	}
	public void setUniversityAbbreviation(Abbreviation universityAbbreviation) {
		this.universityAbbreviation = universityAbbreviation;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	@Override
	public String toString() {
		return "University [id=" + id + ", name=" + name + ", universityAddress=" + universityAddress
				+ ", universityAbbreviation=" + universityAbbreviation + ", college=" + college + "]";
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
		University other = (University) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
