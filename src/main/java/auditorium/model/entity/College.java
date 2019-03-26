package auditorium.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "college")
public class College {

	@Id
	@Column(name = "college_id", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", length = 60, nullable = false, unique = true)
	private String name;
	
	@JoinColumn(name = "university_id", nullable = false)
	private University university;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "abbreviation_id", nullable = false)
	private Abbreviation collegeAbbreviation;
	
	@Column(name = "contact_email", length = 60, nullable = false)
	private String email;
	//
	@ManyToMany(mappedBy = "colleagues")
	private List<Corp> corps;
}
