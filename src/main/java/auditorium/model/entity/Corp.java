package auditorium.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "corp")
public class Corp {

	@Id
	@Column(name = "corp_id", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", length = 60, nullable = false, unique = true)
	private String name;
	
	@OneToOne
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;
	
	@Column(name = "schedule", length = 240, nullable = false)
	private String schedule;
	
	@OneToOne
	@JoinColumn(name = "abbreviation_id", nullable = false)
	private Abbreviation corpAbbreviation;
	
	@Column(name = "security_number", length = 25, nullable = false, unique = true)
	private Integer securityNumber;
	//
	@ManyToMany
	@JoinTable(
			name = "college_corp",
			joinColumns = { @JoinColumn(name = "college_id") },
			inverseJoinColumns = {  @JoinColumn(name = "corp_id") }
			)
	private List<College> colleagues; 
	
	
	private List<Class> classes;
}
