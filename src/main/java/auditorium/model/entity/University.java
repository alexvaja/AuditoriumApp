package auditorium.model.entity;

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
	
}
