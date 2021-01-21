package practice.yogiyo.entity.Restaurant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.yogiyo.entity.Restaurant.RestaurantType;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private RestaurantType restaurantType;

    public Category(RestaurantType restaurantType) {
        this.restaurantType = restaurantType;
    }
}
