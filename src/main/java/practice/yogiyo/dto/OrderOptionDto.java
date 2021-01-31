package practice.yogiyo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderOptionDto {
    private String optionName;
    private Integer optionPrice;
    private Integer optionQuantity;
}
