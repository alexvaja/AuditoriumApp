package smartCardUniversity.SHARED.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "college_id", nullable = false)
	private College registerCollege;
	
	@Column(name = "checked", nullable = false)
	private Boolean checked;
	//
	@OneToOne
	@JoinTable(
			name = "register_role",
			joinColumns = { @JoinColumn(name = "register_id") },
			inverseJoinColumns = { @JoinColumn(name = "role_id") } 
			)
	private Role registerRole;
	
	public Register()
	{
		super();
	}
	public Register(Integer id, String email, String password, College registerCollege, Boolean checked,
			Role registerRole) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.registerCollege = registerCollege;
		this.checked = checked;
		this.registerRole = registerRole;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public College getRegisterCollege() {
		return registerCollege;
	}

	public void setRegisterCollege(College registerCollege) {
		this.registerCollege = registerCollege;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Role getRegisterRole() {
		return registerRole;
	}

	public void setRegisterRole(Role registerRole) {
		this.registerRole = registerRole;
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", email=" + email + ", password=" + password + ", registerCollege="
				+ registerCollege + ", checked=" + checked + ", registerRole=" + registerRole + "]";
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
		Register other = (Register) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
