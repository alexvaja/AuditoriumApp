package auditorium.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import auditorium.constants.MenuStates;

@Entity
@Table(name="menu")
public class Menu 
{
	@Id
	@Column(name="id_menu", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="date", length = 60, nullable = false)
	private String date;
	
	@Column(name="state", length = 60, nullable = false)
	private String state;
	
	@Column(name="title", length = 60, nullable = false)
	private String title;
	//
	@OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
	private List<Dish> dishes;
	
	public Menu() {
		super();
		this.dishes = new ArrayList<>();
		this.state = MenuStates.NEW.toString();
	}
}