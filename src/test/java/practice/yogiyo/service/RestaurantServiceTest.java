package practice.yogiyo.service;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.yogiyo.dto.MenuCategoryDto;
import practice.yogiyo.dto.OptionCategoryDto;
import practice.yogiyo.dto.RestaurantDto;
import practice.yogiyo.entity.Menu.*;
import practice.yogiyo.entity.Restaurant.Category;
import practice.yogiyo.entity.Restaurant.QRestaurant;
import practice.yogiyo.entity.Restaurant.Restaurant;
import practice.yogiyo.entity.Restaurant.RestaurantType;
import practice.yogiyo.repository.CategoryRepository;
import practice.yogiyo.repository.RestaurantQueryRepository;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static practice.yogiyo.entity.Menu.QMenu.menu;
import static practice.yogiyo.entity.Menu.QMenuCategory.menuCategory;
import static practice.yogiyo.entity.Restaurant.QRestaurant.*;

@SpringBootTest
@Transactional
class RestaurantServiceTest {
    @Autowired RestaurantService restaurantService;
    @Autowired RestaurantQueryRepository restaurantQueryRepository;
    @Autowired EntityManager em;
    @Autowired CategoryRepository categoryRepository;
    @Autowired JPAQueryFactory queryFactory;
    
    @Test
    public void 카테고리가져오기() throws Exception{
        // given
        List<MenuCategory> fetch = queryFactory
                .selectFrom(menuCategory)
                .join(menuCategory.restaurant, restaurant)
                .where(restaurant.id.eq(1L))
                .fetch();
        // when

        for (MenuCategory category : fetch) {
            System.out.println("category.getName() = " + category.getName());
        }
    }
    @Test
    public void 메뉴가져오기() throws Exception {
        // given
        List<Menu> result = restaurantQueryRepository.findMenuByRestaurantId(1L);
        // when
        for (Menu fetch1 : result) {
            System.out.println("fetch1.toString() = " + fetch1.toString());
        }
    }

    @Test
    public void 옵션가져오기() throws Exception{
        // given
        List<Option> result = restaurantQueryRepository.findOptionByMenuId(1L);
        for (Option option : result) {
            System.out.println("option.toString() = " + option.toString());
        }
        // when

        // then
        
    }
    @Test
    public void 메뉴변환() throws Exception{
        // given
        List<MenuCategoryDto> menus = restaurantService.getMenus(1L);
        for (MenuCategoryDto menuCategoryDto : menus) {
            System.out.println("menuCategoryDto.getName() = " + menuCategoryDto.getName());
            for (Menu menu : menuCategoryDto.getMenus()) {
                System.out.println("menu.getName() = " + menu.getName());
                System.out.println("menu.getPrice() = " + menu.getPrice());
            }
        }
    }     
    @Test
    public void 옵션변환() throws Exception{
        // given
        List<OptionCategoryDto> options = restaurantService.getOptions(1L);
        for (OptionCategoryDto optionCategoryDto : options) {
            System.out.println("optionCategoryDto.getName() = " + optionCategoryDto.getName());
            for (Option option : optionCategoryDto.getOptions()) {
                System.out.println("option.getName() = " + option.getName());
                System.out.println("option.getPrice() = " + option.getPrice());
            }
        }
    } 
    
    @Test
    public void 식당찾기() throws Exception{
        // given
        Restaurant restaurant = restaurantQueryRepository.findRestaurantByMenuId(10L);
        System.out.println("restaurant.getName() = " + restaurant.getName());
        // when
        
        // then
        
    }
}