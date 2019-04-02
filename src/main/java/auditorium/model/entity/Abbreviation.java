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

}
