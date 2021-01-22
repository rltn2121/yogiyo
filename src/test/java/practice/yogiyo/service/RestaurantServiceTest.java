package practice.yogiyo.service;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.yogiyo.dto.RestaurantDto;
import practice.yogiyo.entity.Menu.Menu;
import practice.yogiyo.entity.Menu.MenuCategory;
import practice.yogiyo.entity.Menu.QMenu;
import practice.yogiyo.entity.Menu.QMenuCategory;
import practice.yogiyo.entity.Restaurant.Category;
import practice.yogiyo.entity.Restaurant.QRestaurant;
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
    public void 메뉴가져오기() throws Exception{
        // given
        List<Menu> fetch = queryFactory
                .selectFrom(menu)
                .join(menu.menuCategory, menuCategory)

                .where(
                        menuCategory.in(
                                JPAExpressions
                                        .selectFrom(menuCategory)
                                        .join(menuCategory.restaurant, restaurant)
                                        .where(restaurant.id.eq(1L))
                        )
                ).fetch();
        // when
        for (Menu fetch1 : fetch) {
            System.out.println("fetch1.toString() = " + fetch1.toString());
        }
        // then
        
    }
    

}