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
    public String toKoeran(RestaurantType restaurantType) {
        String ret = "";
        switch (restaurantType) {
            case CVS:
                ret = "편의점마트";
                break;
            case SNACK:
                ret = "분식";
                break;
            case DESSERT:
                ret = "카페디저트";
                break;
            case SINGLE:
                ret = "1인분주문";
                break;
            case FRANCHISE:
                ret = "프랜차이즈";
                break;
            case CHICKEN:
                ret = "치킨";
                break;
            case CHINESE:
                ret = "중국집";
                break;
            case WESTERN:
                ret = "피자양식";
                break;
            case JAPANESE:
                ret = "일식돈까스";
                break;
            case JOKBAL:
                ret = "족발보쌈";
                break;
            case KOREAN:
                ret = "한식";
                break;
            case MIDNIGHT:
                ret = "야식";
                break;
        }
        return ret;
    }
    public String toEnglish(String categoryName) {
        String ret = "";
        switch (categoryName) {
            case "편의점마트":
                ret = "CVS";
                break;
            case "분식":
                ret = "SNACK";
                break;
            case "카페디저트":
                ret = "DESSERT";
                break;
            case "1인분주문":
                ret = "SINGLE";
                break;
            case "프랜차이즈":
                ret = "FRANCHISE";
                break;
            case "치킨":
                ret = "CHICKEN";
                break;
            case "중국집":
                ret = "CHINESE";
                break;
            case "피자양식":
                ret = "WESTERN";
                break;
            case "일식돈까스":
                ret = "JAPANESE";
                break;
            case "족발보쌈":
                ret = "JOKBAL";
                break;
            case "한식":
                ret = "KOREAN";
                break;
            case "야식":
                ret = "MIDNIGHT";
                break;
        }
        return ret;
    }
}
