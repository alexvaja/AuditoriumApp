package auditorium.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "register")
public class Register {

	@Id
	@Column(name = "id_register", length = 11, nullable = false,  unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "email", length = 60, nullable = false, unique = true)
	private String email;
	
	@Column(name = "password", length = 120, nullable = false)
	private String password;
	
	@OneToOne
	@JoinColumn(name = "college_id", nullable = false)
	private College registerCollege;
	
	@Column(name = "checked", nullable = false)
	private Boolean checked;
	//
	@OneToOne
	@JoinTable(
			name = "register_role",
			joinColumns = {@JoinColumn(name = "register_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private List<Role> registerRole;
	
	
}
