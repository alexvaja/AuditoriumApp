package auditorium.model.entity;

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

}

