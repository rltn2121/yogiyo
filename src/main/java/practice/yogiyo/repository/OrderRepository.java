package practice.yogiyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.yogiyo.entity.Member.Member;
import practice.yogiyo.entity.Order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
