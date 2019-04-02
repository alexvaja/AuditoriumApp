package auditorium.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@Column(name = "address_id", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "street", length = 120, nullable = false)
	private String street;
	
	@Column(name = "city", length = 60, nullable = false)
	private String city;
	// 
	@OneToOne(mappedBy = "personAddress")
	private Person person;
	
	@OneToOne(mappedBy = "universityAddress")
	private University university;
	
	@OneToOne(mappedBy = "corpAddress")
 	private Corp cord;
	
}
