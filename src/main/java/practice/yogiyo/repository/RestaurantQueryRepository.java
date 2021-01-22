package practice.yogiyo.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import practice.yogiyo.dto.QRestaurantPreviewDto;
import practice.yogiyo.dto.RestaurantPreviewDto;
import practice.yogiyo.entity.Restaurant.*;

import javax.persistence.EntityManager;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;
import static practice.yogiyo.entity.Restaurant.QCategory.*;
import static practice.yogiyo.entity.Restaurant.QRestaurant.*;
import static practice.yogiyo.entity.Restaurant.QRestaurantCategory.*;
import static practice.yogiyo.entity.Review.QReview.review;

@Repository
@RequiredArgsConstructor
public class RestaurantQueryRepository {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public List<RestaurantPreviewDto> getRestaurantPreview(String categoryName) {
        return queryFactory
                .select(
                        new QRestaurantPreviewDto(
                                restaurant.id,
                                restaurant.name,
                                review.avgScore.avg(),
                                review.count(),
                                restaurant.minDeliverablePrice,
                                restaurant.deliveryPrice))
                .from(review)
                .rightJoin(review.restaurant, restaurant)
                .where(restaurantIn(categoryName)
                )
                .groupBy(restaurant.id)
                .fetch();
    }

    private BooleanExpression restaurantIn(String categoryName) {
        return restaurant.in(
                // 특정 카테고리에 해당하는 식당 정보
                JPAExpressions.select(restaurant)
                        .distinct()
                        .from(restaurantCategory)
                        .join(restaurantCategory.restaurant, restaurant)
                        .where(
                                categoryEq(categoryName)
                        )
        );
    }


    private BooleanExpression categoryEq(String categoryName) {
        if (!hasText(categoryName)) {
            return null;
        }
        return restaurantCategory.category.eq(
                findCategoryByCategoryName(categoryName)
        );
    }


    private Category findCategoryByCategoryName(String categoryName) {
        return queryFactory
                .selectFrom(category)
                .where(category.restaurantType.eq(RestaurantType.valueOf(categoryName.toUpperCase())))
                .fetchOne();
    }
}