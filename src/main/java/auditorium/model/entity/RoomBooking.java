package auditorium.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "room_booking")
public class RoomBooking {

	@Id
	@Column(name = "id_room_booking", length = 25, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private AppUser appUser;
	
	@ManyToOne
	@JoinColumn(name = "classroom_id", nullable = false)
	private Classroom classroom;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "start_hour", nullable = false)
	private String startHour;
	
	@Column(name = "finish_hour", nullable = false)
	private String finishHour;
	
	@Column(name = "is_open", nullable = false)
	private Boolean isOpen;
	//
	@OneToMany(mappedBy = "roomBooking", fetch = FetchType.EAGER)
	private List<SeatBooking> seatBookings;
}
