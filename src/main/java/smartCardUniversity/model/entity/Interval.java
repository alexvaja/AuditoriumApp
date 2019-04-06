package smartCardUniversity.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "intervals")
public class Interval {

	@Id
	@Column(name = "id_interval", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "week_day", length = 60, nullable = false)
	private String weekDay;
	
	@Column(name = "start_hour", length = 60, nullable = false)
	private String startHour;
	
	@Column(name = "finish_hpur", length = 60, nullable = false)
	private String finisHour;
	
	@ManyToOne
	@JoinColumn(name = "schedule_id", nullable = false)
	private Schedule schedule;

	public Interval(Integer id, String weekDay, String startHour, String finisHour, Schedule schedule) {
		super();
		this.id = id;
		this.weekDay = weekDay;
		this.startHour = startHour;
		this.finisHour = finisHour;
		this.schedule = schedule;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public String getStartHour() {
		return startHour;
	}

	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	public String getFinisHour() {
		return finisHour;
	}

	public void setFinisHour(String finisHour) {
		this.finisHour = finisHour;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Interval [id=" + id + ", weekDay=" + weekDay + ", startHour=" + startHour + ", finisHour=" + finisHour
				+ ", schedule=" + schedule + "]";
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
		Interval other = (Interval) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
