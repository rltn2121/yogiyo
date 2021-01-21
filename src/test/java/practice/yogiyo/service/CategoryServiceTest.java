package practice.yogiyo.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.yogiyo.entity.Restaurant.Category;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CategoryServiceTest {
    @Autowired CategoryService categoryService;
@Test
public void 카테고리이름으로카테고리찾기() throws Exception{
    // given
    String categoryName = "CHICKEN";
    Category categoryByName = categoryService.findCategoryByName(categoryName);
    Assertions.assertThat(categoryByName.getRestaurantType()).isEqualTo(categoryName);
    // when

    // then

}
}