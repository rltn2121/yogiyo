package practice.yogiyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.yogiyo.entity.Member.Member;
import practice.yogiyo.entity.Menu.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
