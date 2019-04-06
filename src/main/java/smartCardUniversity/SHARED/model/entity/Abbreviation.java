package smartCardUniversity.SHARED.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "abbreviation")
public class Abbreviation {

	@Id
	@Column(name = "abbreviation_id", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "abbreviation", length = 60, nullable = false, unique = true)
	private String abbreviation;
	//
	@OneToOne(mappedBy = "universityAbbreviation")
	private University university;
	
	@OneToOne(mappedBy = "corpAbbreviation")
	private Corp corp;
	
	@OneToOne(mappedBy = "collegeAbbreviation")
	private College college;

	
	
	public Abbreviation(Integer id, String abbreviation, University university, Corp corp, College college) {
		super();
		this.id = id;
		this.abbreviation = abbreviation;
		this.university = university;
		this.corp = corp;
		this.college = college;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
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
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}

	
	@Override
	public String toString() {
		return "Abbreviation [id=" + id + ", abbreviation=" + abbreviation + ", university=" + university + ", corp="
				+ corp + ", college=" + college + "]";
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
		Abbreviation other = (Abbreviation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
