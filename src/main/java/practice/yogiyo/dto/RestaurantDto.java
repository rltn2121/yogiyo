package practice.yogiyo.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class RestaurantDto {
    private Long id;
    private String name;
    @QueryProjection
    public RestaurantDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
