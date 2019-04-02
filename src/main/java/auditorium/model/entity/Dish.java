package auditorium.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dish")
public class Dish 
{
	@Id
	@Column(name = "id_dish")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "menu_id", nullable = false)
	private Menu menu;
	//
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "dish_food",
			joinColumns = { @JoinColumn(name = "id_dish") },
			inverseJoinColumns = { @JoinColumn(name = "id_food") }
			)
	private List<Food> foods;

}
