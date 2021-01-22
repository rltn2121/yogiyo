package practice.yogiyo.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class ReviewDto {
    private Integer taste;
    private Integer delivery;
    private Integer quantity;
    private Double avgScore;
    private Long reviewCount;
    @QueryProjection
    public ReviewDto(Integer taste, Integer delivery, Integer quantity, Long reviewCount) {
        this.taste = taste;
        this.delivery = delivery;
        this.quantity = quantity;
        this.reviewCount = reviewCount;
        avgScore = Math.round((taste + delivery + quantity)*3.0)/10.0;
    }
}
