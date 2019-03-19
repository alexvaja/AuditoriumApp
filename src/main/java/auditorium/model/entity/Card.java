package auditorium.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card {

	@Id
	@Column(name = "card_id", length = 25, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "card_number", length = 25, nullable = false, unique = true)
	private String cardNumber; 
	//
	@ManyToMany(mappedBy = "cards")
	private List<User> users;
	
	public Card() {
		super();
	}

	public Card(Integer id, String cardNumber) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	//medota speciala de generat numar random pt card

	@Override
	public String toString() {
		return "Card [id=" + id + ", cardNumber=" + cardNumber + ", users=" + users + "]";
	}	
}
