package smartCardUniversity.SHARED.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "college")
public class College {

	@Id
	@Column(name = "id_college", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", length = 60, nullable = false, unique = true)
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "university_id", nullable = false)
	private University university;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "abbreviation_id", nullable = false)
	private Abbreviation collegeAbbreviation;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id", nullable = false)
	private Contact contact;
	//
	@ManyToMany(mappedBy = "colleagues")
	private List<Corp> corps;

	@OneToMany(mappedBy = "userCollege"/* , fetch = FetchType.EAGER */)
	private List<AppUser> appUsers;

	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	public College(Integer id, String name, University university, Abbreviation collegeAbbreviation, Contact contact) {
		super();
		this.id = id;
		this.name = name;
		this.university = university;
		this.collegeAbbreviation = collegeAbbreviation;
		this.contact = contact;
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

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Abbreviation getCollegeAbbreviation() {
		return collegeAbbreviation;
	}

	public void setCollegeAbbreviation(Abbreviation collegeAbbreviation) {
		this.collegeAbbreviation = collegeAbbreviation;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Corp> getCorps() {
		return corps;
	}

	public void setCorps(List<Corp> corps) {
		this.corps = corps;
	}

	public List<AppUser> getAppUsers() {
		return appUsers;
	}

	public void setAppUsers(List<AppUser> appUsers) {
		this.appUsers = appUsers;
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
		College other = (College) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", university=" + university + ", collegeAbbreviation="
				+ collegeAbbreviation + ", contact=" + contact + "]";
	}
}
