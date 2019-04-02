package auditorium.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "seat")
public class Seat {

	@Id
	@Column(name = "id_seat", length = 25, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "seats", length = 240, nullable = false)
	private String seats;
	//
	@ManyToMany(mappedBy = "seats", fetch = FetchType.EAGER)
	private Classroom classrooms;
}