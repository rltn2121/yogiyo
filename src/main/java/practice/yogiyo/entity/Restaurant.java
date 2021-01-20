package practice.yogiyo.entity;

import javax.persistence.*;

@Entity
public class Restaurant {
    @Id @GeneratedValue
    @Column(name = "restaurantId")
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
