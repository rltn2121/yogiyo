package practice.yogiyo.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String category;

    @QueryProjection
    public CategoryDto(Long id, String category) {
        this.id = id;
        this.category = category;
    }
}
