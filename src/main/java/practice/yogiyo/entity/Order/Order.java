package practice.yogiyo.entity.Order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.yogiyo.entity.EmbeddedType.Address;
import practice.yogiyo.entity.Member.Member;
import practice.yogiyo.entity.Restaurant.Restaurant;
import practice.yogiyo.entity.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private String orderNumber;

    public Order(Restaurant restaurant, String paymentType, String request, String orderType, Integer deliveryPrice, Integer deliveryDiscount, Address address, OrderStatus orderStatus) {
        this.restaurant = restaurant;
        this.paymentType = paymentType;
        this.request = request;
        this.orderType = orderType;
        this.deliveryPrice = deliveryPrice;
        this.deliveryDiscount = deliveryDiscount;
        this.address = address;
        this.orderStatus = orderStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String paymentType;
    private String request;
    private String orderType;
    private Integer deliveryPrice;
    private Integer deliveryDiscount;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @Embedded
    private Address address;

    // 주문내역 조인해서 가져오기
}
