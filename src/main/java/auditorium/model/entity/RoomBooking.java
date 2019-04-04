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
	private AppUser userRoom;
	
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
	
	public RoomBooking(Integer id, AppUser userRoom, Classroom classroom, Date date, String startHour,
			String finishHour, Boolean isOpen, List<SeatBooking> seatBookings) {
		super();
		this.id = id;
		this.userRoom = userRoom;
		this.classroom = classroom;
		this.date = date;
		this.startHour = startHour;
		this.finishHour = finishHour;
		this.isOpen = isOpen;
		this.seatBookings = seatBookings;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AppUser getUserRoom() {
		return userRoom;
	}

	public void setUserRoom(AppUser userRoom) {
		this.userRoom = userRoom;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStartHour() {
		return startHour;
	}

	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	public String getFinishHour() {
		return finishHour;
	}

	public void setFinishHour(String finishHour) {
		this.finishHour = finishHour;
	}

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	public List<SeatBooking> getSeatBookings() {
		return seatBookings;
	}

	public void setSeatBookings(List<SeatBooking> seatBookings) {
		this.seatBookings = seatBookings;
	}

	@Override
	public String toString() {
		return "RoomBooking [id=" + id + ", userRoom=" + userRoom + ", classroom=" + classroom + ", date=" + date
				+ ", startHour=" + startHour + ", finishHour=" + finishHour + ", isOpen=" + isOpen + ", seatBookings="
				+ seatBookings + "]";
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
		RoomBooking other = (RoomBooking) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
		
}
