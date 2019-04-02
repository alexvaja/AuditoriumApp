package auditorium.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class Food 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_food", length = 11, nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "name", length = 60, nullable = false)
	private String name;
	
	@Column(name = "ingredients", length = 60, nullable = false)
	private String ingredients;
	
	@Column(name = "weight", length = 11, nullable = false)
	private int weight;
	
	@Column(name = "price", length = 11, nullable = false)
	private double price;
	
	@ManyToMany(mappedBy = "foods")
	private List<Dish> dishes;
	
	@OneToMany(mappedBy = "foodd")
	private List<OrderQuantity> foodss;
	

}