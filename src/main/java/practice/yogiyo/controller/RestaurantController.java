package practice.yogiyo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import practice.yogiyo.dto.MenuCategoryDto;
import practice.yogiyo.dto.OptionCategoryDto;
import practice.yogiyo.dto.RestaurantDto;
import practice.yogiyo.dto.RestaurantPreviewDto;
import practice.yogiyo.entity.Menu.Menu;
import practice.yogiyo.service.CategoryService;
import practice.yogiyo.service.MenuService;
import practice.yogiyo.service.RestaurantService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final MenuService menuService;
    private final CategoryService categoryService;

    /**
     * todo
     * 쿼리스트링으로 전달받도록 수정하기
     * ex. /restaurants?category=치킨
     * html -> Controller로 값 전달 어떻게 할 지 몰라서 보류
     */

    @GetMapping("/restaurants/{categoryName}")
    public String findRestaurantByCategory(@PathVariable("categoryName") String categoryName, Model model) {
        List<RestaurantPreviewDto> restaurantPreviewDtos
                = restaurantService.findByCategoryName(categoryName);
        model.addAttribute("restaurantPreviewDtos",restaurantPreviewDtos);
        model.addAttribute("category", categoryName);
        return "/restaurants/searchByCategory";
    }

    @GetMapping("/restaurants/info/{restaurantId}")
    public String getRestaurantInfo(@PathVariable("restaurantId") Long restaurantId, Model model) {
        List<MenuCategoryDto> menuCategoryDtoList = restaurantService.getMenus(restaurantId);
        model.addAttribute("menuCategoryDtoList", menuCategoryDtoList);
        return "/restaurants/menuList";
    }

    @GetMapping("/menu/{menuId}")
    public String getMenuInfo(@PathVariable("menuId") Long menuId, Model model) {
        List<OptionCategoryDto> optionCategoryDtoList = restaurantService.getOptions(menuId);
        Menu menu = menuService.findMenuById(menuId);
        model.addAttribute("optionCategoryDtoList", optionCategoryDtoList);
        model.addAttribute("menu", menu);
        return "/menus/optionList";
    }
}
