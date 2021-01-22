package practice.yogiyo.service;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.yogiyo.dto.*;
import practice.yogiyo.entity.Order.QOrder;
import practice.yogiyo.entity.Restaurant.Category;
import practice.yogiyo.entity.Restaurant.QRestaurant;
import practice.yogiyo.entity.Restaurant.Restaurant;
import practice.yogiyo.entity.Restaurant.RestaurantType;
import practice.yogiyo.entity.Review.QReview;
import practice.yogiyo.entity.Review.Review;
import practice.yogiyo.repository.RestaurantQueryRepository;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.util.StringUtils.hasText;
import static practice.yogiyo.entity.Order.QOrder.*;
import static practice.yogiyo.entity.Restaurant.QCategory.category;
import static practice.yogiyo.entity.Restaurant.QRestaurant.*;
import static practice.yogiyo.entity.Restaurant.QRestaurantCategory.restaurantCategory;
import static practice.yogiyo.entity.Review.QReview.*;

@SpringBootTest
@Transactional
class ReviewServiceTest {
    @Autowired
    ReviewService reviewService;
    
    @Autowired
    JPAQueryFactory queryFactory;
    @Autowired
    EntityManager em;
    @Autowired
    RestaurantQueryRepository restaurantQueryRepository;

    
    @Test
    public void 리뷰평균() throws Exception{
        List<ReviewDto> fetch1 = queryFactory
                .select(new QReviewDto(review.taste, review.delivery, review.quantity, review.count()))
                .from(review)
                .fetch();
        for (ReviewDto reviewDto : fetch1) {
            System.out.println("reviewDto.getTaste() = " + reviewDto.getTaste());
            System.out.println("reviewDto = " + reviewDto.getDelivery());
            System.out.println("reviewDto.getQuantity() = " + reviewDto.getQuantity());
            System.out.println("reviewDto.getAvgScore() = " + reviewDto.getAvgScore());
        }
    }
    
    @Test
    public void 식당리뷰점수() throws Exception{
        // given
        List<Tuple> fetch = queryFactory
                .select(restaurant.name, review.avgScore.avg())
                .from(restaurant)
                .leftJoin(review.restaurant, restaurant)
                .fetch();
        // when
        for (Tuple tuple : fetch) {
            System.out.println("tuple.get(0, String.class) = " + tuple.toString());
        }
        
        // then
        
    }
    @Test
    public void 특정식당리뷰조회() throws Exception{
//        // given
//        List<Review> fetch = queryFactory
//                .selectFrom(review)
//                .rightJoin(review.restaurant, restaurant)
//                .fetch();
//        for (Review review : fetch) {
//            System.out.println("---------------------------------");
//            System.out.println("review.restaurant.getName() = " + review.restaurant.getName());
//            System.out.println("review.contents = " + review.contents);
//            System.out.println("review.getAvgScore() = " + review.getAvgScore());
//        }
    }

    @Test
    public void 식당미리보기() throws Exception{

        List<RestaurantPreviewDto> chicken =
                restaurantQueryRepository.getRestaurantPreview("");

        for (RestaurantPreviewDto restaurantPreviewDto : chicken) {
            System.out.println("restaurantPreviewDto.toString() = " + restaurantPreviewDto.getName());
            System.out.println("restaurantPreviewDto.getAvgScore() = " + restaurantPreviewDto.getAvgScore());
            System.out.println("restaurantPreviewDto.getDeliveryPrice() = " + restaurantPreviewDto.getDeliveryPrice());
            System.out.println("restaurantPreviewDto.getMinDeliverablePrice() = " + restaurantPreviewDto.getMinDeliverablePrice());
            System.out.println("restaurantPreviewDto.getReviewCount() = " + restaurantPreviewDto.getReviewCount());
        }
    }
    
    @Test
    public void ㅅㅂ() throws Exception{
        // given
        String categoryName = "";
        List<Restaurant> fetch = queryFactory.select(restaurant)
                .distinct()
                .from(restaurantCategory)
                .join(restaurantCategory.restaurant, restaurant)
                .where(
                        categoryEq(categoryName)
                ).fetch();
        // when
        for (Restaurant restaurant : fetch) {
            System.out.println("restaurant.getName() = " + restaurant.getName());
        }
        // then
        
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