package practice.yogiyo.entity.Order;

import lombok.AccessLevel;
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
    private String deliveryDiscount;
    @Embedded
    private Address address;

    // 주문내역 조인해서 가져오기
}
