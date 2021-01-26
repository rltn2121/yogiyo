package practice.yogiyo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import practice.yogiyo.entity.EmbeddedType.Address;
import practice.yogiyo.entity.Member.Member;
import practice.yogiyo.entity.Menu.Menu;
import practice.yogiyo.entity.Menu.Option;
import practice.yogiyo.entity.Order.Order;
import practice.yogiyo.entity.Order.OrderMenu;
import practice.yogiyo.entity.Order.OrderOption;
import practice.yogiyo.entity.Restaurant.Restaurant;
import practice.yogiyo.repository.*;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestaurantQueryRepository restaurantQueryRepository;
    private final MenuRepository menuRepository;
    private final OptionRepository optionRepository;
    private final OrderMenuRepository orderMenuRepository;
    private final OrderOptionRepository orderOptionRepository;

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
                address);
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
}
