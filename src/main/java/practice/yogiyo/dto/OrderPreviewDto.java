package practice.yogiyo.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import practice.yogiyo.entity.Menu.Menu;
import practice.yogiyo.entity.Order.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderPreviewDto {
    private Long orderId;
    private LocalDateTime orderDateTime;
    private OrderStatus orderStatus;
    private String restaurantName;
    private List<MenuInfo> menuInfoList = new ArrayList<>();

    public OrderPreviewDto(Long orderId, LocalDateTime orderDateTime, OrderStatus orderStatus, String restaurantName) {
        this.orderId = orderId;
        this.orderDateTime = orderDateTime;
        this.orderStatus = orderStatus;
        this.restaurantName = restaurantName;
    }


    public class MenuInfo{
        String menuName;
        Integer quantity;
        public MenuInfo(String menuName, Integer quantity){
            this.menuName = menuName;
            this.quantity = quantity;
        }

        public String getMenuName() {
            return menuName;
        }

        public Integer getQuantity() {
            return quantity;
        }
    }
    public void addMenuName(String menuName, Integer quantity){
        menuInfoList.add(new MenuInfo(menuName, quantity));
    }
}
