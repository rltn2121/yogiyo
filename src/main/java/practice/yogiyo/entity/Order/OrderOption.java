package practice.yogiyo.entity.Order;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.yogiyo.entity.Menu.Menu;
import practice.yogiyo.entity.Menu.Option;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderOption {
    @Id
    @GeneratedValue
    @Column(name = "order_option_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_menu_id")
    private OrderMenu orderMenu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id")
    private Option option;

    private Integer quantity;

    public OrderOption(OrderMenu orderMenu, Option option, Integer quantity) {
        this.orderMenu = orderMenu;
        this.option = option;
        this.quantity = quantity;
    }
}
