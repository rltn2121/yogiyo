package practice.yogiyo.entity.Menu;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import practice.yogiyo.entity.BaseTimeEntity;
import practice.yogiyo.entity.EmbeddedType.Url;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Menu extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "menu_id")
    private Long id;

    private String name;

    private Integer price;

    // 특정 식당에서 분류하는 카테고리
    // 치킨 메뉴: 후라이드, 양념치킨, 매운양념
    // 순살 메뉴: 순살 후라이드, 순살 양념치킨, 순살 매운양념
    @ManyToOne
    @JoinColumn(name = "menu_category_id")
    private MenuCategory menuCategory;

    @Embedded
    private Url url;
}
