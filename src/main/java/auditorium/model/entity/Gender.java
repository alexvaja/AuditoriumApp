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

@Entity
@Table(name = "gender")
public class Gender {

	@Id
	@Column(name = "id_gender", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "gender", length = 1, nullable = false, unique = true)
	private String gender;
	//
	@OneToMany(mappedBy = "gender", fetch = FetchType.EAGER)
	private List<Person> persons;

}
