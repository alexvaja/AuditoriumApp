 package smartCardUniversity.SHARED.model.entity;

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

	public Corp()
	{
		super();
	}
	public Corp(Integer id, String name, Address corpAddress, Schedule schedule, Abbreviation corpAbbreviation,
			List<College> colleagues, List<Classroom> classrooms) {
		super();
		this.id = id;
		this.name = name;
		this.corpAddress = corpAddress;
		this.schedule = schedule;
		this.corpAbbreviation = corpAbbreviation;
		this.colleagues = colleagues;
		this.classrooms = classrooms;
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

	public Address getCorpAddress() {
		return corpAddress;
	}

	public void setCorpAddress(Address corpAddress) {
		this.corpAddress = corpAddress;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Abbreviation getCorpAbbreviation() {
		return corpAbbreviation;
	}

	public void setCorpAbbreviation(Abbreviation corpAbbreviation) {
		this.corpAbbreviation = corpAbbreviation;
	}

	public List<College> getColleagues() {
		return colleagues;
	}

	public void setColleagues(List<College> colleagues) {
		this.colleagues = colleagues;
	}

	public List<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
	}

	@Override
	public String toString() {
		return "Corp [id=" + id + ", name=" + name + ", corpAddress=" + corpAddress + ", schedule=" + schedule
				+ ", corpAbbreviation=" + corpAbbreviation + ", colleagues=" + colleagues + ", classrooms=" + classrooms
				+ "]";
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
		Corp other = (Corp) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
