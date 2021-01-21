package practice.yogiyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.yogiyo.entity.Member.Member;

public interface OrderRepository extends JpaRepository<Member, Long> {
}
