package practice.yogiyo.entity;

import javax.persistence.*;

@Entity
public class Category {
    @Id @GeneratedValue
    @Column(name = "CategoryId")
    private Long id;

    @Enumerated(EnumType.STRING)
    private RestaurantType restaurantType;
}
