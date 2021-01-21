package practice.yogiyo.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.yogiyo.dto.RestaurantDto;
import practice.yogiyo.entity.Restaurant.Category;
import practice.yogiyo.entity.Restaurant.RestaurantType;
import practice.yogiyo.repository.CategoryRepository;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RestaurantServiceTest {
    @Autowired RestaurantService restaurantService;
    @Autowired
    EntityManager em;
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void 카테고리로검색() throws Exception{
        // given
        Category category = categoryRepository.findById(3L).get();
        // when
        List<RestaurantDto> byCategory = restaurantService.findByCategory(category);
        // then
        for (RestaurantDto restaurantDto : byCategory) {
            System.out.println("restaurantDto.getName() = " + restaurantDto.getName());
        }

    }
}