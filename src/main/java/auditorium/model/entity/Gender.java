package auditorium.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import auditorium.constants.EGender;

@Entity
@Table(name = "gender")
public class Gender {

	@Id
	@Column(name = "gender_id", length = 25, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "gender", length = 1, nullable = false, unique = true)
	private EGender gender;
	//
	@OneToMany(mappedBy = "registerGender")
	private List<Register> registers;
	
	@OneToMany(mappedBy = "personGender", fetch = FetchType.EAGER)
	private List<Person> persons;

	public Gender() {
		super();
	}

	public Gender(Integer id, EGender gender) {
		super();
		this.id = id;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EGender getGender() {
		return gender;
	}

	public void setGender(EGender gender) {
		this.gender = gender;
	}

	public List<Register> getRegisters() {
		return registers;
	}

	public void setRegisters(List<Register> registers) {
		this.registers = registers;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "Gender [id=" + id + ", gender=" + gender + ", registers=" + registers + ", persons=" + persons + "]";
	}
}
