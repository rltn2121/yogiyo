package practice.yogiyo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.yogiyo.entity.Restaurant.Category;
import practice.yogiyo.entity.Restaurant.RestaurantType;
import practice.yogiyo.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    public Category findCategoryByName(String categoryName) {
        System.out.println("categoryName = " + categoryName);
        Category category = categoryRepository.findByRestaurantType(categoryName);
        System.out.println("category.getRestaurantType() = " + category.getRestaurantType());
        return category;
    }
}
