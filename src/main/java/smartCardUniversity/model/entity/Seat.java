package smartCardUniversity.model.entity;

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
@Table(name = "seat")
public class Seat {

	@Id
	@Column(name = "id_seat", length = 25, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "seat", length = 240, nullable = false)
	private String seatList;
	//
	@ManyToMany(mappedBy = "seats", fetch = FetchType.EAGER)
	private List<Classroom> classrooms;
	
	public Seat(Integer id, String seatList, List<Classroom> classrooms) {
		super();
		this.id = id;
		this.seatList = seatList;
		this.classrooms = classrooms;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeatList() {
		return seatList;
	}

	public void setSeatList(String seatList) {
		this.seatList = seatList;
	}

	public List<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", seatList=" + seatList + ", classrooms=" + classrooms + "]";
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
		Seat other = (Seat) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
