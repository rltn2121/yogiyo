package practice.yogiyo.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import practice.yogiyo.entity.Menu.Menu;
import practice.yogiyo.entity.Menu.Option;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OptionCategoryDto {
    private String name;
    public List<Option> options = new ArrayList<>();

    @QueryProjection

    public OptionCategoryDto(String name) {
        this.name = name;
    }

    public void addOptions(Option option) {
        options.add(option);
    }
}

