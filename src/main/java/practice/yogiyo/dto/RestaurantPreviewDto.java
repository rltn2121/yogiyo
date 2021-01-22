package practice.yogiyo.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class RestaurantPreviewDto {
    private Long id;
    private String name;
    private Double avgScore;
    private Long reviewCount;
    private Integer minDeliverablePrice;
    private Integer deliveryPrice;

    @QueryProjection
    public RestaurantPreviewDto(Long id,String name, Double avgScore, Long reviewCount, Integer minDeliverablePrice, Integer deliveryPrice) {
        this.id = id;
        this.name = name;
        this.avgScore = avgScore;
        this.reviewCount = reviewCount;
        this.minDeliverablePrice = minDeliverablePrice;
        this.deliveryPrice = deliveryPrice;
    }
}
