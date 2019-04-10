package smartCardUniversity.LOGIN.models.DTO;

import smartCardUniversity.SHARED.model.entity.College;
import smartCardUniversity.SHARED.model.entity.Person;

public class AppUserDTO
{
	private Integer id;
	private String email;	
	private String password;	
	private Person person;
	private College userCollege;
	
	public AppUserDTO()
	{
		
	}
	public AppUserDTO(Integer id, String email, String password, Person person, College userCollege) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.person = person;
		this.userCollege = userCollege;
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
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public College getUserCollege() {
		return userCollege;
	}
	public void setUserCollege(College userCollege) {
		this.userCollege = userCollege;
	}
	
	@Override
	public String toString() {
		return "AppUserDTO [id=" + id + ", email=" + email + ", password=" + password + ", person=" + person
				+ ", userCollege=" + userCollege + "]";
	}
}
