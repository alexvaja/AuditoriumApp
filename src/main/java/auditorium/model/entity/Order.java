package auditorium.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@Column(name = "id_order", length = 11, nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user", nullable = false)
	private AppUser userOrder;
	
	@OneToMany(mappedBy = "order")
	private List<OrderQuantity> orderQuantities;
	
	@Column(name = "taken", nullable = false)
	private Boolean taken;

	@Column(name = "date", length = 60, nullable = false)
	private String date;

	public Order(Integer id, AppUser userOrder, List<OrderQuantity> orderQuantities, Boolean taken, String date) {
		super();
		this.id = id;
		this.userOrder = userOrder;
		this.orderQuantities = orderQuantities;
		this.taken = taken;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AppUser getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(AppUser userOrder) {
		this.userOrder = userOrder;
	}

	public List<OrderQuantity> getOrderQuantities() {
		return orderQuantities;
	}

	public void setOrderQuantities(List<OrderQuantity> orderQuantities) {
		this.orderQuantities = orderQuantities;
	}

	public Boolean getTaken() {
		return taken;
	}

	public void setTaken(Boolean taken) {
		this.taken = taken;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userOrder=" + userOrder + ", orderQuantities=" + orderQuantities + ", taken="
				+ taken + ", date=" + date + "]";
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
