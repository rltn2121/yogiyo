package practice.yogiyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.yogiyo.entity.Order.Order;
import practice.yogiyo.entity.Order.OrderOption;

public interface OrderOptionRepository extends JpaRepository<OrderOption, Long> {
}
