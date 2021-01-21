package practice.yogiyo.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.yogiyo.entity.Restaurant.RestaurantType;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String category;

    @QueryProjection
    public CategoryDto(Long id, RestaurantType category) {
        this.id = id;
        this.category = getCategoryKor(category);
    }
    public String getCategoryKor(RestaurantType restaurantType) {
        String ret = "";
        switch (restaurantType) {
            case CVS:
                ret = "편의점/마트";
                break;
            case SNACK:
                ret = "분식";
                break;
            case DESSERT:
                ret = "카페/디저트";
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
                ret = "피자/양식";
                break;
            case JAPANESE:
                ret = "일식/돈까스";
                break;
            case JOKBAL:
                ret = "족발/보쌈";
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
}
