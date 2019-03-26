package auditorium.model.entity;

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
	@Column(name = "abbreviation_id", length = 25, nullable = false, unique = true)
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
	
	public Abbreviation() {
		super();
	}

	public Abbreviation(Integer id, String abbreviation) {
		super();
		this.id = id;
		this.abbreviation = abbreviation;
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
}
