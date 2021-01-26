package practice.yogiyo.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import practice.yogiyo.dto.QRestaurantPreviewDto;
import practice.yogiyo.dto.RestaurantPreviewDto;
import practice.yogiyo.entity.Menu.Menu;
import practice.yogiyo.entity.Menu.Option;
import practice.yogiyo.entity.Menu.QOption;
import practice.yogiyo.entity.Menu.QOptionCategory;
import practice.yogiyo.entity.Restaurant.*;

import javax.persistence.EntityManager;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;
import static practice.yogiyo.entity.Menu.QMenu.menu;
import static practice.yogiyo.entity.Menu.QMenuCategory.menuCategory;
import static practice.yogiyo.entity.Menu.QOption.option;
import static practice.yogiyo.entity.Menu.QOptionCategory.optionCategory;
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

    /**
     * 특정 식당의 메뉴 카테고리별 메뉴 조회
     */
    public List<Menu> findMenuByRestaurantId(Long restaurantId) {
        return queryFactory
                .selectFrom(menu)
                .join(menu.menuCategory, menuCategory).fetchJoin()  // N+1문제 -> fetch join()
                .where(
                        menuCategory.in(
                                JPAExpressions
                                        .selectFrom(menuCategory)
                                        .join(menuCategory.restaurant, restaurant)
                                        .where(restaurant.id.eq(restaurantId))
                        )
                ).fetch();
    }

    /**
     * 특정 메뉴의 옵션 카테고리별 옵션 조회
     */
    public List<Option> findOptionByMenuId(Long menuId) {
        return queryFactory
                .selectFrom(option)
                .join(option.optionCategory, optionCategory).fetchJoin()  // N+1문제 -> fetch join()
                .where(
                        optionCategory.in(
                                JPAExpressions
                                        .selectFrom(optionCategory)
                                        .join(optionCategory.menu, menu)
                                        .where(menu.id.eq(menuId))
                        )
                ).fetch();
    }

    public Restaurant findRestaurantByMenuId(Long menuId) {
        return queryFactory
                .select(QRestaurant.restaurant)
                .from(menuCategory)
                .join(menuCategory.restaurant, QRestaurant.restaurant)
                .where(menuCategory.eq(
                        JPAExpressions
                                .select(menuCategory)
                                .from(menu)
                                .join(menu.menuCategory, menuCategory)
                                .where(menu.id.eq(menuId))
                ))
                .fetchOne();

    }

    /**
     * PRIVATE
     */
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
