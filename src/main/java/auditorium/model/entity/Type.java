package auditorium.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "type")
public class Type {

	@Id
	@Column(name = "id_type", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "type", length = 60, nullable = false, unique = true)
	private String type;
	
	@Column(name = "description", length = 120)
	private String description;
	//
	@ManyToMany(mappedBy = "types", fetch = FetchType.EAGER)
	private List<Classroom> classrooms;
}
