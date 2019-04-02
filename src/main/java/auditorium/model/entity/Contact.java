package auditorium.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@Column(name = "id_contact", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "email", length = 60, nullable = false)
	private String email;
	
	@Column(name = "phone_number", length = 60, nullable = false)
	private String phoneNumber;
	
	@Column(name = "fax_number", length = 60, nullable = false)
	private String faxNumber;
	//
	@OneToOne(mappedBy = "contact")
	private College college;
	
}
