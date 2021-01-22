package practice.yogiyo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import practice.yogiyo.dto.RestaurantDto;
import practice.yogiyo.dto.RestaurantPreviewDto;
import practice.yogiyo.service.CategoryService;
import practice.yogiyo.service.RestaurantService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final CategoryService categoryService;

    @GetMapping("/restaurants/{categoryName}")
    public String findRestaurantByCategory(@PathVariable("categoryName") String categoryName, Model model) {
        List<RestaurantPreviewDto> restaurantPreviewDtos
                = restaurantService.findByCategoryName(categoryName);
        model.addAttribute("restaurantPreviewDtos",restaurantPreviewDtos);
        model.addAttribute("category", categoryName);
        return "/restaurants/searchByCategory";
    }
//
//    @GetMapping("/restaurants")
//    public String findAll(Model model) {
//        List<RestaurantDto> restaurantDtos = restaurantService.findAll();
//        model.addAttribute("restaurantDtos", restaurantDtos);
//        return "/restaurants/restaurantList";
//    }
}
