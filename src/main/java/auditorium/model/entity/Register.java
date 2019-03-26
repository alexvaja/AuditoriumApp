package auditorium.model.entity;

import java.util.Date;
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
import javax.persistence.Table;

@Entity
@Table(name = "register")
public class Register {

	@Id
	@Column(name = "register_id", length = 25, nullable = false,  unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name", length = 60, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 60, nullable = false)
	private String lastName;
	
	@Column(name = "birth_date", length = 60, nullable = false)
	private Date birthDate;
	
	@ManyToOne
	@JoinColumn(name = "gender_id", nullable = false)
	private Gender registerGender;
	
	@Column(name = "password", length = 120, nullable = false)
	private String password;
	
	@Column(name = "email", length = 60, nullable = false, unique = true)
	private String email;
	
	@Column(name = "phone_number", length = 60, nullable = false, unique = true)
	private String phoneNumber;
	
	@Column(name = "checked", nullable = false)
	private Boolean checked;
	//
	@ManyToMany(/*fetch = FetchType.EAGER*/)
	@JoinTable(
			name = "register_role",
			joinColumns = {@JoinColumn(name = "register_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private List<Role> registerRoles;
	
	
}
