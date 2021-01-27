package practice.yogiyo.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import practice.yogiyo.entity.Menu.Menu;
import practice.yogiyo.entity.Order.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderMenuDto {
    private Long orderId;
    private LocalDateTime orderDateTime;
    private OrderStatus orderStatus;
    private String restaurantName;
    private String menuName;
    private Integer quantity;

    @QueryProjection
    public OrderMenuDto(Long orderId, LocalDateTime orderDateTime, OrderStatus orderStatus, String restaurantName, String menuName, Integer quantity) {
        this.orderId = orderId;
        this.orderDateTime = orderDateTime;
        this.orderStatus = orderStatus;
        this.restaurantName = restaurantName;
        this.menuName = menuName;
        this.quantity = quantity;
    }
}
