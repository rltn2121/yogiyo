package practice.yogiyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.yogiyo.entity.Member.Member;
import practice.yogiyo.entity.Restaurant.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
