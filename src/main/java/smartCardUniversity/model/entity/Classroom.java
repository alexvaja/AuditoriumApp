package smartCardUniversity.model.entity;

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
	
	@Column(name = "floor", length = 60, nullable = false)
	private String floor;
	
	@Column(name = "number", length = 11, nullable = false)
	private int number;
	
	@Column(name = "capacity", length = 11, nullable = false)
	private int capacity;
	
	@Column(name = "description", nullable = false)
	private String description;
	//
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

	
	public Classroom(Integer id, Corp corp, String floor, int number, int capacity, String description,
			List<Seat> seats, List<Type> types, List<RoomBooking> roomBookings) {
		super();
		this.id = id;
		this.corp = corp;
		this.floor = floor;
		this.number = number;
		this.capacity = capacity;
		this.description = description;
		this.seats = seats;
		this.types = types;
		this.roomBookings = roomBookings;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Corp getCorp() {
		return corp;
	}
	public void setCorp(Corp corp) {
		this.corp = corp;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	public List<Type> getTypes() {
		return types;
	}
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	public List<RoomBooking> getRoomBookings() {
		return roomBookings;
	}
	public void setRoomBookings(List<RoomBooking> roomBookings) {
		this.roomBookings = roomBookings;
	}

	
	@Override
	public String toString() {
		return "Classroom [id=" + id + ", corp=" + corp + ", floor=" + floor + ", number=" + number + ", capacity="
				+ capacity + ", description=" + description + ", seats=" + seats + ", types=" + types
				+ ", roomBookings=" + roomBookings + "]";
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
		Classroom other = (Classroom) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
