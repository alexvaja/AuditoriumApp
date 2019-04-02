package auditorium.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card {

	@Id
	@Column(name = "id_card", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "card_number", length = 25, nullable = false, unique = true)
	private String cardNumber; 
	//
	@OneToOne(mappedBy = "card")
	private List<AppUser> appUser;

}
