package practice.yogiyo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.yogiyo.entity.Member.Member;
import practice.yogiyo.entity.Menu.Menu;
import practice.yogiyo.repository.MenuRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public Menu findMenuById(Long menuId) {
        Menu menu = menuRepository.findById(menuId).get();
        return menu;
    }
}
