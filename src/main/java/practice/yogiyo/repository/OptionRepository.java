package practice.yogiyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.yogiyo.entity.Member.Member;
import practice.yogiyo.entity.Menu.Option;

public interface OptionRepository extends JpaRepository<Option, Long> {
}
