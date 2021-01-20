package practice.yogiyo.entity;

import javax.persistence.*;

@Entity
public class Menu {
    @Id @GeneratedValue
    @Column(name = "menuId")
    private Long id;

    private String name;

    private Integer price;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    @Embedded
    private Url url;

    // 특정 식당에서 분류하는 카테고리
    // 치킨 메뉴: 후라이드, 양념치킨, 매운양념
    // 순살 메뉴 순살 후라이드, 순살 양념치킨, 순살 매운양념
    private String category;
}
