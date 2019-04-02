package auditorium.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@OneToMany(mappedBy = "userCollege", fetch = FetchType.EAGER)
	private List<AppUser> appUsers;
	
	@OneToMany(mappedBy = "registerCollege", fetch = FetchType.EAGER)
	private List<Register> registers;
	
}
