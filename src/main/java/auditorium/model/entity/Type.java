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
	public Type(Integer id, String type, String description, List<Classroom> classrooms) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.classrooms = classrooms;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Classroom> getClassrooms() {
		return classrooms;
	}
	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", type=" + type + ", description=" + description + ", classrooms=" + classrooms
				+ "]";
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
		Type other = (Type) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
