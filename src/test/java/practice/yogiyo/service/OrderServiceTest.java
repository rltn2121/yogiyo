package practice.yogiyo.service;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.yogiyo.entity.Menu.Menu;
import practice.yogiyo.entity.Menu.Option;
import practice.yogiyo.entity.Order.*;

import java.util.List;

import static practice.yogiyo.entity.Order.QOrder.*;
import static practice.yogiyo.entity.Order.QOrderMenu.*;
import static practice.yogiyo.entity.Order.QOrderOption.*;

@SpringBootTest
@Transactional
public class OrderServiceTest {
    @Autowired
    JPAQueryFactory queryFactory;

    @Test
    public void 주문내역조인() throws Exception{
        // given
        List<Tuple> fetch = queryFactory
                .select(order, orderMenu)
                .from(orderMenu)
                .join(orderMenu.order, order)
                .where(order.id.eq(100L))
                .fetch();
        for (Tuple tuple : fetch) {
            System.out.println("order id = " + tuple.get(0,Order.class).getId());
            System.out.println("menu name = " + tuple.get(1, OrderMenu.class).getMenu().getName());
            System.out.println("quantity = " + tuple.get(1, OrderMenu.class).getQuantity());
        }
    }

    @Test
    public void 주문메뉴_주문옵션조회() throws Exception{
        // given
        Long orderId = 100L;
        List<Tuple> fetch = queryFactory
                .select(orderMenu, orderOption)
                .from(orderMenu)
                .leftJoin(orderOption.orderMenu, orderMenu)
                .where(order.id.eq(orderId))
                .fetch();
        // when
        for (Tuple tuple : fetch) {

        }
        // then

    }

    @Test
    public void asdf() throws Exception{
        // given
        Long orderId = 100L;
        List<Tuple> fetch = queryFactory
                .select(orderOption, orderMenu)
                .from(orderOption)
                .rightJoin(orderOption.orderMenu, orderMenu).fetchJoin()
                .where(orderMenu.order.id.eq(orderId))
                .fetch();

        // when
        for (Tuple tuple : fetch) {
            System.out.println("tuple = " + tuple);
        }

//        for (Tuple tuple : fetch) {
//            OrderOption orderOption = tuple.get(0, OrderOption.class);
//            OrderMenu orderMenu = tuple.get(1, OrderMenu.class);
//
//            System.out.println("orderMenu.getMenu().getName() = " + orderMenu.getMenu().getName());
//            System.out.println("orderMenu.getQuantity() = " + orderMenu.getQuantity());
//            if (orderOption != null) {
//                System.out.println("orderOption.getOption().getName() = " + orderOption.getOption().getName());
//                System.out.println("orderOption.getQuantity() = " + orderOption.getQuantity());
//            }
//        }
        // then

    }
}
