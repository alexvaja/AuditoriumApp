package auditorium.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seat_booking")
public class SeatBooking {

	@Id
	@Column(name = "id_seat_booking")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private AppUser appUser;
	
	@JoinColumn(name = "room_booking_id", nullable = false)
	private RoomBooking roomBooking;
	
	@Column(name = "seat_number", length = 60, nullable = false)
	private String seatNumber;
}
