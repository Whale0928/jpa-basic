package hellojpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Getter
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;

	@ManyToOne //주문 to 회원
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	private LocalDate orderDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<>();

	public void addOrder(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}
}
