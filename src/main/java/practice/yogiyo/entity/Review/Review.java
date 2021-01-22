package practice.yogiyo.entity.Review;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.yogiyo.entity.BaseTimeEntity;
import practice.yogiyo.entity.Order.Order;
import practice.yogiyo.entity.Restaurant.Restaurant;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "reviewId")
    public Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    public Order order;

    public String contents;

    public Integer taste;
    public Integer quantity;
    public Integer delivery;

    public Double avgScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    public Restaurant restaurant;


}
