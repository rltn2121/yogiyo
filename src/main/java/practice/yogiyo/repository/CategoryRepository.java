package practice.yogiyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.yogiyo.entity.Restaurant.Category;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findByRestaurantType(String restaurantType);
}
