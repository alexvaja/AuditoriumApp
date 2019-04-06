package smartCardUniversity.model.entity;

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

	public Food(Integer id, String name, String ingredients, int weight, double price, List<Dish> dishes,
			List<OrderQuantity> foodss) {
		super();
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
		this.weight = weight;
		this.price = price;
		this.dishes = dishes;
		this.foodss = foodss;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

	public List<OrderQuantity> getFoodss() {
		return foodss;
	}

	public void setFoodss(List<OrderQuantity> foodss) {
		this.foodss = foodss;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", ingredients=" + ingredients + ", weight=" + weight + ", price="
				+ price + ", dishes=" + dishes + ", foodss=" + foodss + "]";
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
		Food other = (Food) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}