package practice.yogiyo.dto;

import lombok.Getter;
import practice.yogiyo.entity.Order.OrderMenu;
import practice.yogiyo.entity.Order.OrderOption;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderDetailDto {
    private Long orderMenuId;
    private String menuName;
    private Integer menuPrice;
    private Integer quantity;
    private Integer totalMenuOptionPrice;
    private List<OrderOptionDto> orderOptionDtoList = new ArrayList<>();

    public OrderDetailDto(Long orderMenuId, String menuName, Integer menuPrice, Integer quantity) {
        this.orderMenuId = orderMenuId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.quantity = quantity;
    }
    public void addOrderOptionDtoList(String optionName, Integer optionPrice, Integer optionQuantity){
        orderOptionDtoList.add(new OrderOptionDto(optionName, optionPrice, optionQuantity));
    }
    public Integer getTotalMenuOptionPrice(){
        int ret = menuPrice*quantity;
        for (OrderOptionDto orderOptionDto : orderOptionDtoList) {
            ret+=orderOptionDto.getOptionPrice()*orderOptionDto.getOptionQuantity();
        }
        return ret;
    }
}
