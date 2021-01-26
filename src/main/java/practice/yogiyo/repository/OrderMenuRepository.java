package practice.yogiyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.yogiyo.entity.Order.Order;
import practice.yogiyo.entity.Order.OrderMenu;

public interface OrderMenuRepository extends JpaRepository<OrderMenu, Long> {
}
