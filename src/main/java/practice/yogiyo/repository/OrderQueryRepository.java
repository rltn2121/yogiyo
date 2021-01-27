package practice.yogiyo.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import practice.yogiyo.dto.OrderMenuDto;
import practice.yogiyo.dto.QOrderMenuDto;
import practice.yogiyo.entity.Order.OrderMenu;

import javax.persistence.EntityManager;
import java.util.List;

import static practice.yogiyo.entity.Order.QOrderMenu.orderMenu;
import static practice.yogiyo.entity.Order.QOrderOption.orderOption;

@Repository
@RequiredArgsConstructor
public class OrderQueryRepository {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
    public List<OrderMenuDto> getOrderMenuDtos() {
        return queryFactory
                .select(
                        new QOrderMenuDto(
                                orderMenu.order.id,
                                orderMenu.order.createdDate,
                                orderMenu.order.orderStatus,
                                orderMenu.order.restaurant.name,
                                orderMenu.menu.name,
                                orderMenu.quantity)
                )
                .from(orderMenu)
                .fetch();
    }

    public List<OrderMenu> getMenuOption(Long orderId) {
        return queryFactory
                .selectFrom(orderMenu)
                .distinct()
                .leftJoin(orderMenu.orderOption, orderOption).fetchJoin()
                .where(orderMenu.order.id.eq(orderId))
                .fetch();
    }
}
