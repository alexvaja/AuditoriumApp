package auditorium.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@Column(name = "id_role", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "role", length = 60, nullable = false, unique = true)
	private String role;
	//
	@OneToOne(mappedBy = "registerRole")
	private Register register;
	
	@OneToOne(mappedBy = "usersRole")
	private AppUser appUser;
}
