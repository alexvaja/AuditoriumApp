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
	@Column(name = "abbreviation_id", length = 25, unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "abbreviation", length = 25, unique = true, nullable = false)
	private String abbreviation;
	//
	@OneToOne(mappedBy = "universityAbbreviation")
	private University university;
	
//	@OneToOne(mappedBy = "abbreviation")
//	private Corp corp;
//	
//	@OneToOne(mappedBy = "abbreviation")
//	private College college;
}
