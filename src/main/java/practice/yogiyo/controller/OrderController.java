package practice.yogiyo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practice.yogiyo.dto.OrderDetailDto;
import practice.yogiyo.dto.OrderPreviewDto;
import practice.yogiyo.entity.Menu.Menu;
import practice.yogiyo.entity.Menu.Option;
import practice.yogiyo.repository.OptionRepository;
import practice.yogiyo.repository.OrderRepository;
import practice.yogiyo.service.MenuService;
import practice.yogiyo.service.OrderService;
import practice.yogiyo.service.RestaurantService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final MenuService menuService;
    private final RestaurantService restaurantService;
    private final OptionRepository optionRepository;
    private final OrderService orderService;

    @PostMapping("/orders")
    public String addToOrderSheet(
            @RequestParam("menuId") Long menuId,
            @RequestParam("quantity") int quantity,
            @Nullable @RequestParam("checkedOptions") Long[] checkedOptions,
            @RequestParam("paymentType") String paymentType,
            @RequestParam("request") String request,
            @RequestParam("orderType") String orderType,
            @RequestParam("city") String city,
            @RequestParam("region") String region) {
        orderService.createOrder(menuId, quantity, checkedOptions, paymentType, request, orderType, city, region);
        return "redirect:/";
    }

    @GetMapping("/orders")
    public String getOrderList(Model model){
        List<OrderPreviewDto> orderPreviewDtos = orderService.getOrderPreviewDtos();
        model.addAttribute("orderPreviewDtos", orderPreviewDtos);
        return "/orders/orderPreviewList";
    }

    @GetMapping("/orders/{orderId}")
    public String getOrderDetail(@PathVariable("orderId") Long orderId, Model model){
        List<OrderDetailDto> orderDetailDtos = orderService.getOrderDetail(orderId);
        model.addAttribute("orderDetailDtos", orderDetailDtos);
        return "/orders/orderDetail";
    }
}
