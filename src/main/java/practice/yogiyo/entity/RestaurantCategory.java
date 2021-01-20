package practice.yogiyo.entity;

import javax.persistence.*;

@Entity
public class RestaurantCategory {
    @Id @GeneratedValue
    @Column(name = "RestaurantCategoryId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RestaurantId")
    private Restaurant restaurant;
}
