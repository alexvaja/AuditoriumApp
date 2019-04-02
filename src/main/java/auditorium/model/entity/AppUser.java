package auditorium.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class AppUser {

	@Id
	@Column(name = "user_id", length = 25, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "password", length = 120, nullable = false)
	private String password;
	
	@Column(name = "email", length = 60, nullable = false, unique = true)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "university_id", nullable = false)
	private University university;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;
	
	@ManyToMany(/*fetch = FetchType.EAGER*/)
	@JoinTable(
			name = "user_role",
			joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "role_id") }
			)
	private List<Role> usersRoles;
	
	@ManyToMany(/*fetch = FetchType.EAGER*/)
	@JoinTable(
			name = "user_card",
			joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "card_id") }
			)
	private List<Card> cards;
	
}
