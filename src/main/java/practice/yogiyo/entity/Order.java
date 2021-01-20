package practice.yogiyo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Order {
    @Id @GeneratedValue
    @Column(name = "orderId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    private String paymentType;
    private String request;
    private String orderType;
    private Integer deliveryPrice;
    private String deliveryDiscount;
    private Address address;
}
