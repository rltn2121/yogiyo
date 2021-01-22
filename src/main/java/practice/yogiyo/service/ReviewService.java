package practice.yogiyo.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.yogiyo.repository.OrderRepository;
import practice.yogiyo.repository.RestaurantRepository;
import practice.yogiyo.repository.ReviewRepository;

import java.util.List;

import static practice.yogiyo.entity.Order.QOrder.*;
import static practice.yogiyo.entity.Restaurant.QRestaurant.restaurant;
import static practice.yogiyo.entity.Review.QReview.*;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrderRepository orderRepository;
    private final JPAQueryFactory queryFactory;



}
