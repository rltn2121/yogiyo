package practice.yogiyo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import practice.yogiyo.dto.RestaurantDto;
import practice.yogiyo.entity.Restaurant.Category;
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
        System.out.println("categoryName = " + categoryName);
        String ret = "";
        switch (categoryName) {
            case "편의점/마트":
                ret = "CVS";
                break;
            case "분식":
                ret = "SNACK";
                break;
            case "카페/디저트":
                ret = "DESSERT";
                break;
            case "1인분주문":
                ret = "SINGLE";
                break;
            case "프랜차이즈":
                ret = "FRANCHISE";
                break;
            case "치킨":
                ret = "CHICKEN";
                break;
            case "중국집":
                ret = "CHINESE";
                break;
            case "피자/양식":
                ret = "WESTERN";
                break;
            case "일식/돈까스":
                ret = "JAPANESE";
                break;
            case "족발/보쌈":
                ret = "JOKBAL";
                break;
            case "한식":
                ret = "KOREAN";
                break;
            case "야식":
                ret = "MIDNIGHT";
                break;
        }
        Category category = categoryService.findCategoryByName(ret);
        List<RestaurantDto> restaurantDtos = restaurantService.findByCategory(category);
        model.addAttribute("restaurantDtos",restaurantDtos);
        return "/restaurants/searchByCategory";
    }
}
