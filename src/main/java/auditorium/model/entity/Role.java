package auditorium.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import auditorium.constants.ERole;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@Column(name = "role_id", length = 25, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "role", length = 60, nullable = false, unique = true)
	private ERole role;
	//
	@ManyToMany(mappedBy = "registerRoles")
	private List<Register> registers;
	
	@ManyToMany(mappedBy = "usersRoles")
	private List<User> users;
}
