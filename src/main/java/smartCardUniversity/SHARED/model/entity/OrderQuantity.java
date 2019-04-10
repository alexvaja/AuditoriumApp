package smartCardUniversity.SHARED.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_quantity")
public class OrderQuantity {

	@Id
	@Column(name = "id_quantity", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "food_id", nullable = false)
	private Food foodd;
	
	@Column(name = "quantity", length = 11, nullable = false)
	private Integer quantity;

	public OrderQuantity(Integer id, Order order, Food foodd, Integer quantity) {
		super();
		this.id = id;
		this.order = order;
		this.foodd = foodd;
		this.quantity = quantity;
	}

	public OrderQuantity()
	{
		super();
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Food getFoodd() {
		return foodd;
	}

	public void setFoodd(Food foodd) {
		this.foodd = foodd;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderQuantity [id=" + id + ", order=" + order + ", foodd=" + foodd + ", quantity=" + quantity + "]";
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
		OrderQuantity other = (OrderQuantity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}

