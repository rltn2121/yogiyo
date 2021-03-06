package practice.yogiyo.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import practice.yogiyo.entity.Menu.Menu;
import practice.yogiyo.entity.Menu.MenuCategory;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MenuCategoryDto {

    private String name;
    public List<Menu> menus = new ArrayList<>();
    @QueryProjection

    public MenuCategoryDto(String name) {
        this.name = name;
    }

    public void addMenus(Menu menu){
        menus.add(menu);
    }
}
