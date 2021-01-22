package practice.yogiyo.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.yogiyo.dto.RestaurantDto;
import practice.yogiyo.dto.RestaurantPreviewDto;
import practice.yogiyo.entity.Restaurant.Category;
import practice.yogiyo.entity.Restaurant.RestaurantType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RestaurantQueryRepositoryTest {
    @Autowired RestaurantQueryRepository restaurantQueryRepository;

    @Test
    public void 카테고리별음식점() throws Exception{
        // given
        String categoryName = "chicken";
        List<RestaurantPreviewDto> search = restaurantQueryRepository.getRestaurantPreview(categoryName);
        // when
        for (RestaurantPreviewDto restaurantDto : search) {
            System.out.println("restaurantDto.getName() = " + restaurantDto.getName());
        }
        // then
        
    }

//    @Test
//    public void test() throws Exception{
//        // given
//        String categoryName = "dessert";
//        List<Category> test = restaurantQueryRepository.test(categoryName);
//        Category result = test.get(0);
//        System.out.println("result.getRestaurantType() = " + result.getRestaurantType());
//        System.out.println("result.getId() = " + result.getId());
//        Assertions.assertThat(test.size()).isEqualTo(1);
//        Assertions.assertThat(test.get(0).getRestaurantType()).isEqualTo(RestaurantType.valueOf(categoryName.toUpperCase()));
//        // when
//
//        // then
//
//    }
}