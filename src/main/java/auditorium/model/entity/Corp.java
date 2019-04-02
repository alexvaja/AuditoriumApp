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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "corp")
public class Corp {

	@Id
	@Column(name = "id_corp", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", length = 60, nullable = false, unique = true)
	private String name;
	
	@OneToOne
	@JoinColumn(name = "address_id", nullable = false)
	private Address corpAddress;
	
	@OneToOne
	@JoinColumn(name = "schedule_id", nullable = false)
	private Schedule schedule;
	
	@OneToOne
	@JoinColumn(name = "abbreviation_id", nullable = false)
	private Abbreviation corpAbbreviation;
	//
	@ManyToMany
	@JoinTable(
			name = "college_corp",
			joinColumns = { @JoinColumn(name = "id_college") },
			inverseJoinColumns = {  @JoinColumn(name = "id_corp") }
			)
	private List<College> colleagues; 
	
	@OneToMany(mappedBy = "corp")
	private List<Classroom> classrooms;
}
