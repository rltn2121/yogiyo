package practice.yogiyo.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import practice.yogiyo.entity.Menu.Menu;
import practice.yogiyo.entity.Order.OrderOption;

import java.util.List;

@Getter
public class OrderListDto {
    private Long id;
    private String menuName;
    private Integer menuPrice;
    private Integer quantity;
    private List<OrderOption> orderOptionList;

    @QueryProjection

    public OrderListDto(Long id, String menuName, Integer menuPrice, Integer quantity, List<OrderOption> orderOptionList) {
        this.id = id;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.quantity = quantity;
        this.orderOptionList = orderOptionList;
    }
}
