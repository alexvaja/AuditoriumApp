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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "classroom")
public class Classroom {

	@Id
	@Column(name = "id_classroom", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "corp_id", nullable = false)
	private Corp corp;
	
	@Column(name = "floor", nullable = false)
	private String floor;
	
	@Column(name = "number", nullable = false)
	private int number;
	
	@Column(name = "capacity", nullable = false)
	private int capacity;
	
	@Column(name = "description", nullable = false)
	private String description;
	//continua aici tabelele de many to many!!
	@ManyToMany
	@JoinTable(
			name = "classroom_seat",
			joinColumns = { @JoinColumn(name = "classroom_id") },
			inverseJoinColumns = { @JoinColumn(name = "seat_id") }
			)
	private List<Seat> seats;
	
	@ManyToMany
	@JoinTable(
			name = "classroom_type",
			joinColumns = { @JoinColumn(name = "classroom_id") },
			inverseJoinColumns = { @JoinColumn(name = "type_id") }
			)
	private List<Type> types;
	
	@OneToMany(mappedBy = "classroom")
	private List<RoomBooking> roomBookings;
}
