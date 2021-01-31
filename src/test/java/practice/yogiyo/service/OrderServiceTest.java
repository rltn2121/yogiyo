package practice.yogiyo.service;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.yogiyo.dto.OrderMenuDto;
import practice.yogiyo.dto.OrderPreviewDto;
import practice.yogiyo.dto.QOrderMenuDto;
import practice.yogiyo.entity.Menu.QOption;
import practice.yogiyo.entity.Order.*;

import java.util.List;

import static practice.yogiyo.entity.Menu.QMenu.menu;
import static practice.yogiyo.entity.Menu.QOption.option;
import static practice.yogiyo.entity.Order.QOrder.*;
import static practice.yogiyo.entity.Order.QOrderMenu.*;
import static practice.yogiyo.entity.Order.QOrderOption.*;

@SpringBootTest
@Transactional
public class OrderServiceTest {
    @Autowired
    JPAQueryFactory queryFactory;
    @Autowired
    OrderService orderService;

    @Test
    public void 주문내역조인() throws Exception {
        // given
        List<Tuple> fetch = queryFactory
                .select(order, orderMenu)
                .from(orderMenu)
                .join(orderMenu.order, order)
                .where(order.id.eq(100L))
                .fetch();
        for (Tuple tuple : fetch) {
            System.out.println("order id = " + tuple.get(0, Order.class).getId());
            System.out.println("menu name = " + tuple.get(1, OrderMenu.class).getMenu().getName());
            System.out.println("quantity = " + tuple.get(1, OrderMenu.class).getQuantity());
        }
    }

    @Test
    public void 주문메뉴_주문옵션조회() throws Exception {
        Long orderId = 100L;
        List<OrderMenu> fetch = queryFactory
                .selectFrom(orderMenu)
                .distinct()
                .leftJoin(orderMenu.orderOption, orderOption).fetchJoin()
                .join(orderMenu.menu, menu).fetchJoin()
                .join(orderOption.option, option).fetchJoin()
                .where(orderMenu.order.id.eq(orderId))
                .fetch();

        for (OrderMenu orderMenu : fetch) {
            System.out.println("====== 메뉴 정보 ======");
            System.out.println("id = " + orderMenu.getId());
            System.out.println("메뉴 = " + orderMenu.getMenu().getName());
            System.out.println("가격 = " + orderMenu.getMenu().getPrice());
            System.out.println("수량 = " + orderMenu.getQuantity());
            List<OrderOption> orderOptionList = orderMenu.getOrderOption();
            System.out.println("====== 옵션 정보 ======");
            for (OrderOption orderOption : orderOptionList) {
                System.out.println("  옵션 = " + orderOption.getOption().getName());
                System.out.println("  가격 = " + orderOption.getOption().getPrice());
                System.out.println("  수량 = " + orderOption.getQuantity());
            }
        }
    }

    public List<OrderMenu> getMenuOption(Long orderId) {
        return queryFactory
                .selectFrom(orderMenu)
                .distinct()
                .leftJoin(orderMenu.orderOption, orderOption).fetchJoin()
                .where(orderMenu.order.id.eq(orderId))
                .fetch();
    }

//    @Test
//    public void 주문미리보기() throws Exception{
//        // given
//        List<OrderMenuDto> fetch = getOrderMenuDtos();
//        // when
//
//        for (OrderMenuDto orderPreviewDto : fetch) {
//            System.out.println("주문시간 = " + orderPreviewDto.getOrderDateTime());
//            System.out.println("주문상태 = " + orderPreviewDto.getOrderStatus());
//            System.out.println("식당 = " + orderPreviewDto.getRestaurantName());
//            System.out.println("메뉴 = " + orderPreviewDto.getMenuName());
//            System.out.println("수량 = " + orderPreviewDto.getQuantity());
//        }
//        // then
//
//    }

@Test
public void 서비스테스트() throws Exception{
    // given
    List<OrderPreviewDto> orderPreviewDtos = orderService.getOrderPreviewDtos();
    for (OrderPreviewDto orderPreviewDto : orderPreviewDtos) {
        System.out.println("주문시간 = " + orderPreviewDto.getOrderDateTime());
        System.out.println("식당 = " + orderPreviewDto.getRestaurantName());
        System.out.println("주문상태 = " + orderPreviewDto.getOrderStatus());
        List<OrderPreviewDto.MenuInfo> menuInfoList = orderPreviewDto.getMenuInfoList();
        for (OrderPreviewDto.MenuInfo menuInfo : menuInfoList) {
            System.out.println("  - 메뉴: " + menuInfo.getMenuName());
            System.out.println("  - 수량: " + menuInfo.getQuantity());
        }
    }
    // when

    // then

}
}

