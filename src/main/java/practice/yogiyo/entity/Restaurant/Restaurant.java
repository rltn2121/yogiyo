package practice.yogiyo.entity.Restaurant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.yogiyo.entity.EmbeddedType.Address;
import practice.yogiyo.entity.EmbeddedType.Payment;
import practice.yogiyo.entity.EmbeddedType.Url;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {
    @Id @GeneratedValue
    @Column(name = "restaurant_id")
    private Long id;
    private String name;
    private Integer minDeliverablePrice;
    private Integer deliveryPrice;
    private Integer delivery_discount;
    private Integer discount_rate;

    @Embedded
    private Payment payment;

    @Embedded
    private Url url;
    private String backgroundUrl;
    @Embedded
    private Address address;

    @Embedded
    private RestaurantInfo restaurantInfo;
}
