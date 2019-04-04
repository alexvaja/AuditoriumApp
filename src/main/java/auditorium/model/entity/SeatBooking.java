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
	private AppUser userSeat;
	
	@ManyToOne
	@JoinColumn(name = "room_booking_id", nullable = false)
	private RoomBooking roomBooking;
	
	@Column(name = "seat_number", length = 60, nullable = false)
	private String seatNumber;

	public SeatBooking(Integer id, AppUser userSeat, RoomBooking roomBooking, String seatNumber) {
		super();
		this.id = id;
		this.userSeat = userSeat;
		this.roomBooking = roomBooking;
		this.seatNumber = seatNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AppUser getUserSeat() {
		return userSeat;
	}

	public void setUserSeat(AppUser userSeat) {
		this.userSeat = userSeat;
	}

	public RoomBooking getRoomBooking() {
		return roomBooking;
	}

	public void setRoomBooking(RoomBooking roomBooking) {
		this.roomBooking = roomBooking;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "SeatBooking [id=" + id + ", userSeat=" + userSeat + ", roomBooking=" + roomBooking + ", seatNumber="
				+ seatNumber + "]";
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
		SeatBooking other = (SeatBooking) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
