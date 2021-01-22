package practice.yogiyo.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.yogiyo.dto.QRestaurantDto;
import practice.yogiyo.dto.RestaurantDto;
import practice.yogiyo.dto.RestaurantPreviewDto;
import practice.yogiyo.entity.Restaurant.Category;
import practice.yogiyo.entity.Restaurant.QRestaurant;
import practice.yogiyo.entity.Restaurant.QRestaurantCategory;
import practice.yogiyo.entity.Restaurant.Restaurant;
import practice.yogiyo.repository.RestaurantQueryRepository;
import practice.yogiyo.repository.RestaurantRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

import static practice.yogiyo.entity.Restaurant.QRestaurant.restaurant;
import static practice.yogiyo.entity.Restaurant.QRestaurantCategory.restaurantCategory;

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

}
