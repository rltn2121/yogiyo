package practice.yogiyo.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.yogiyo.dto.MenuCategoryDto;
import practice.yogiyo.dto.OptionCategoryDto;
import practice.yogiyo.dto.RestaurantDto;
import practice.yogiyo.dto.RestaurantPreviewDto;
import practice.yogiyo.entity.Menu.Menu;
import practice.yogiyo.entity.Menu.Option;
import practice.yogiyo.entity.Restaurant.Restaurant;
import practice.yogiyo.repository.RestaurantQueryRepository;
import practice.yogiyo.repository.RestaurantRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantQueryRepository restaurantQueryRepository;
    private final EntityManager entityManager;
    private final JPAQueryFactory queryFactory;
    private final CategoryService categoryService;


    public List<RestaurantDto> findAll() {
        List<Restaurant> findRestaurant = restaurantRepository.findAll();
        List<RestaurantDto> restaurantDtos = findRestaurant.stream()
                .map(r -> new RestaurantDto(r.getId(), r.getName()))
                .collect(Collectors.toList());
        return restaurantDtos;
    }

    public List<RestaurantPreviewDto> findByCategoryName(String categoryName) {
        String keyword = "";
        if(categoryName.equals("전체보기"))
            keyword = null;
        else
            keyword= categoryService.toEnglish(categoryName);
        return restaurantQueryRepository.getRestaurantPreview(keyword);
    }


    public List<MenuCategoryDto> getMenus(Long restaurantId) {
        List<Menu> menuList = restaurantQueryRepository.findMenuByRestaurantId(restaurantId);
        List<MenuCategoryDto> menuCategoryDtos = new ArrayList<>();
        String lastCategory="";
        int idx = -1;
        for (Menu menu : menuList) {
            String currentCategory =menu.getMenuCategory().getName();
            // 마지막 카테고리와 현재 카테고리가 다르면
            if(!lastCategory.equals(currentCategory)){
                // 카테고리 갱신하고 새 객체 생성
                lastCategory = currentCategory;
                menuCategoryDtos.add(new MenuCategoryDto(lastCategory));
                idx++;
            }
            menuCategoryDtos.get(idx).addMenus(menu);
        }
        return menuCategoryDtos;
    }

    public List<OptionCategoryDto> getOptions(Long menuId) {
        List<Option> optionList = restaurantQueryRepository.findOptionByMenuId(menuId);
        List<OptionCategoryDto> optionCategoryDtos = new ArrayList<>();
        String lastCategory="";
        int idx = -1;
        for (Option option : optionList) {
            String currentCategory =option.getOptionCategory().getName();
            // 마지막 카테고리와 현재 카테고리가 다르면
            if(!lastCategory.equals(currentCategory)){
                // 카테고리 갱신하고 새 객체 생성
                lastCategory = currentCategory;
                optionCategoryDtos.add(new OptionCategoryDto(lastCategory));
                idx++;
            }
            optionCategoryDtos.get(idx).addOptions(option);
        }
        return optionCategoryDtos;
    }
}
