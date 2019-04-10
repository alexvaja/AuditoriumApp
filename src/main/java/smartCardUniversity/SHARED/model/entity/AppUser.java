package smartCardUniversity.SHARED.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class AppUser {

	@Id
	@Column(name = "id_user", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "inst_email", length = 60, nullable = false, unique = true)
	private String email;
	
	@Column(name = "password", length = 120, nullable = false)
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;
	
	@ManyToOne/*(cascade = CascadeType.ALL)*/
	@JoinColumn(name = "college_id", nullable = false)
	private College userCollege;
	//
	@OneToOne(/*fetch = FetchType.EAGER*/)
	@JoinTable(
			name = "user_role",
			joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "role_id") }
			)
	private Role userRole;
	
	@OneToOne(/*fetch = FetchType.EAGER*/)
	@JoinTable(
			name = "user_card",
			joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "card_id") }
			)
	private Card card;
	
	@OneToMany(mappedBy = "userBook")
	private List<BookBooking> bookBookings;
	
	@OneToMany(mappedBy = "userSeat")
	private List<SeatBooking> seatBookings; 
	
	@OneToMany(mappedBy = "userRoom")
	private List<RoomBooking> roomBookings;
	
	@OneToMany(mappedBy = "userOrder")
	private List<Order> orders;

	public AppUser()
	{
		
	}
	
	@Override
	public String toString() {
		return "AppUser [id=" + id + ", email=" + email + ", password=" + password;
	}
	
	public AppUser(Integer id, String email, String password, Person person, College userCollege, Role userRole,
			Card card, List<BookBooking> bookBookings, List<SeatBooking> seatBookings, List<RoomBooking> roomBookings,
			List<Order> orders) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.person = person;
		this.userCollege = userCollege;
		this.userRole = userRole;
		this.card = card;
		this.bookBookings = bookBookings;
		this.seatBookings = seatBookings;
		this.roomBookings = roomBookings;
		this.orders = orders;
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
	public Role getUserRole() {
		return userRole;
	}
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public List<BookBooking> getBookBookings() {
		return bookBookings;
	}
	public void setBookBookings(List<BookBooking> bookBookings) {
		this.bookBookings = bookBookings;
	}
	public List<SeatBooking> getSeatBookings() {
		return seatBookings;
	}
	public void setSeatBookings(List<SeatBooking> seatBookings) {
		this.seatBookings = seatBookings;
	}
	public List<RoomBooking> getRoomBookings() {
		return roomBookings;
	}
	public void setRoomBookings(List<RoomBooking> roomBookings) {
		this.roomBookings = roomBookings;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
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
		AppUser other = (AppUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
