package practice.yogiyo.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.yogiyo.dto.QRestaurantDto;
import practice.yogiyo.dto.RestaurantDto;
import practice.yogiyo.entity.Restaurant.Category;
import practice.yogiyo.entity.Restaurant.QRestaurant;
import practice.yogiyo.entity.Restaurant.QRestaurantCategory;
import practice.yogiyo.repository.RestaurantRepository;

import javax.persistence.EntityManager;
import java.util.List;

import static practice.yogiyo.entity.Restaurant.QRestaurant.restaurant;
import static practice.yogiyo.entity.Restaurant.QRestaurantCategory.restaurantCategory;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final EntityManager entityManager;
    private final JPAQueryFactory queryFactory;


    /**
     * select *
     * from RestaurantCategory
     * left join Restaurant
     *
     *
     */
    public List<RestaurantDto> findByCategory(Category category) {
        List<RestaurantDto> result = queryFactory
                .select(new QRestaurantDto(restaurant.id.as("restaurantId"), restaurant.name))
                .from(restaurantCategory)
                .leftJoin(restaurantCategory.restaurant, restaurant)
                .where(
                        categoryEq(category)
                ).fetch();
        return result;
    }
    private BooleanExpression categoryEq(Category category){
        return category != null ?
                restaurantCategory.category.eq(category) : null;
    }
}
