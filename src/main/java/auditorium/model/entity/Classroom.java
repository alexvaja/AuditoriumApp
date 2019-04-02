package auditorium.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class Class {

	@Id
	@Column(name = "class_id", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "corp_id", nullable = false)
	private Corp corp;
	
	@Column(name = "floor", nullable = false)
	private String floor;
	
	@Column(name = "number", nullable = false)
	private int number;
	
	private int capacity;
	
	private String description;
}
