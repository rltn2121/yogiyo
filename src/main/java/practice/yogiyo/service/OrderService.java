package practice.yogiyo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import practice.yogiyo.dto.OrderDetailDto;
import practice.yogiyo.dto.OrderMenuDto;
import practice.yogiyo.dto.OrderPreviewDto;
import practice.yogiyo.entity.EmbeddedType.Address;
import practice.yogiyo.entity.Member.Member;
import practice.yogiyo.entity.Menu.Menu;
import practice.yogiyo.entity.Menu.Option;
import practice.yogiyo.entity.Order.Order;
import practice.yogiyo.entity.Order.OrderMenu;
import practice.yogiyo.entity.Order.OrderOption;
import practice.yogiyo.entity.Order.OrderStatus;
import practice.yogiyo.entity.Restaurant.Restaurant;
import practice.yogiyo.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestaurantQueryRepository restaurantQueryRepository;
    private final MenuRepository menuRepository;
    private final OptionRepository optionRepository;
    private final OrderMenuRepository orderMenuRepository;
    private final OrderOptionRepository orderOptionRepository;
    private final OrderQueryRepository orderQueryRepository;

    @Transactional
    public List<Order> findOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public void createOrder(Long menuId,
                             int quantity,
                             Long[] checkedOptions,
                             String paymentType,
                             String request,
                             String orderType,
                             String city,
                             String region) {
        Address address = new Address(city, region);
        Restaurant restaurant = restaurantQueryRepository.findRestaurantByMenuId(menuId);
        Menu menu = menuRepository.findById(menuId).get();
        Integer deliveryPrice = restaurant.getDeliveryPrice();
        Integer deliveryDiscount = restaurant.getDelivery_discount();
        Order order = new Order(
                restaurant,
                paymentType,
                request,
                orderType,
                deliveryPrice,
                deliveryDiscount,
                address,
                OrderStatus.WAITING);
        orderRepository.save(order);
        OrderMenu orderMenu = new OrderMenu(order, menu, quantity);
        orderMenuRepository.save(orderMenu);


        if(checkedOptions != null){
            for (Long checkedOption : checkedOptions) {
                Option option = optionRepository.findById(checkedOption).get();
                OrderOption orderOption = new OrderOption(orderMenu, option, quantity);
                orderOptionRepository.save(orderOption);
            }
        }
    }

    @Transactional
    public List<OrderPreviewDto> getOrderPreviewDtos() {
        List<OrderMenuDto> orderMenuDtos = orderQueryRepository.getOrderMenuDtos();
        List<OrderPreviewDto> orderPreviewDtos = new ArrayList<>();
        Long lastId = -1L;
        int idx = -1;
        for (OrderMenuDto orderMenuDto : orderMenuDtos) {
            Long nowId = orderMenuDto.getOrderId();
            if(lastId != nowId){
                lastId = nowId;
                orderPreviewDtos.add(new OrderPreviewDto(
                        orderMenuDto.getOrderId(),
                        orderMenuDto.getOrderDateTime(),
                        orderMenuDto.getOrderStatus(),
                        orderMenuDto.getRestaurantName()
                        ));
                idx++;
            }
            orderPreviewDtos.get(idx).addMenuName(orderMenuDto.getMenuName(), orderMenuDto.getQuantity());
        }
        return orderPreviewDtos;
    }

    @Transactional
    public List<OrderDetailDto> getOrderDetail(Long orderId){
        List<OrderMenu> menuOption = orderQueryRepository.getMenuOption(orderId);
        List<OrderDetailDto> orderDetailDtos = new ArrayList<>();
        Long lastId = -1L;
        int idx = -1;
        for (OrderMenu orderMenu : menuOption) {
            Long nowId = orderMenu.getId();
            if(lastId != nowId){
                lastId = nowId;
                orderDetailDtos.add(new OrderDetailDto(
                    orderMenu.getId(),
                        orderMenu.getMenu().getName(),
                        orderMenu.getMenu().getPrice(),
                        orderMenu.getQuantity()
                ));
                idx++;
            }
            List<OrderOption> orderOption = orderMenu.getOrderOption();
            for (OrderOption option : orderOption) {
                orderDetailDtos.get(idx).addOrderOptionDtoList(
                        option.getOption().getName(),
                        option.getOption().getPrice(),
                        option.getQuantity());
            }

        }
        return orderDetailDtos;
    }

    public Integer getTotalPrice(List<OrderDetailDto> orderDetailDtos) {
        int ret = 0;
        for (OrderDetailDto orderDetailDto : orderDetailDtos) {
            ret += orderDetailDto.getTotalMenuOptionPrice();
        }
        return ret;
    }
}
