INSERT INTO yogiyo_toy.category (category_id, restaurant_type) VALUES (1, 'SINGLE');
INSERT INTO yogiyo_toy.category (category_id, restaurant_type) VALUES (2, 'FRANCHISE');
INSERT INTO yogiyo_toy.category (category_id, restaurant_type) VALUES (3, 'CHICKEN');
INSERT INTO yogiyo_toy.category (category_id, restaurant_type) VALUES (4, 'WESTERN');
INSERT INTO yogiyo_toy.category (category_id, restaurant_type) VALUES (5, 'CHINESE');
INSERT INTO yogiyo_toy.category (category_id, restaurant_type) VALUES (6, 'KOREAN');
INSERT INTO yogiyo_toy.category (category_id, restaurant_type) VALUES (7, 'JAPANESE');
INSERT INTO yogiyo_toy.category (category_id, restaurant_type) VALUES (8, 'JOKBAL');
INSERT INTO yogiyo_toy.category (category_id, restaurant_type) VALUES (9, 'MIDNIGHT');
INSERT INTO yogiyo_toy.category (category_id, restaurant_type) VALUES (10, 'SNACK');
INSERT INTO yogiyo_toy.category (category_id, restaurant_type) VALUES (11, 'DESSERT');
INSERT INTO yogiyo_toy.category (category_id, restaurant_type) VALUES (12, 'CVS');

INSERT INTO yogiyo_toy.member (member_id, created_date, last_modified_date, city, region, email, member_type, nickname, password, payment_password, phone) VALUES (6, '2021-01-21 09:08:30', '2021-01-21 09:08:30', null, null, 'rltn2121@naver.com', 'FAMILY', '하이루', '1234', null, '01012341234');
INSERT INTO yogiyo_toy.member (member_id, created_date, last_modified_date, city, region, email, member_type, nickname, password, payment_password, phone) VALUES (7, '2021-01-21 09:08:41', '2021-01-21 09:08:41', null, null, 'rltn212121@gmail.com', 'FAMILY', '바이루', '1234', null, '01023212321');
INSERT INTO yogiyo_toy.member (member_id, created_date, last_modified_date, city, region, email, member_type, nickname, password, payment_password, phone) VALUES (8, '2021-01-21 09:08:58', '2021-01-21 09:08:58', null, null, 'rltn2121@daum.net', 'FAMILY', '헬로우', '455123', null, '01098756542');

INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (1, null, null, '후라이드', 14000, 'https://indabaesori.shop', 'https://indabaesori.shop', 1);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (2, null, null, '양념치킨', 15000, 'https://indabaesori.shop', 'https://indabaesori.shop', 1);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (3, null, null, '매운양념', 15000, 'https://indabaesori.shop', 'https://indabaesori.shop
', 1);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (4, null, null, '순살 후라이드', 15000, 'https://indabaesori.shop', 'https://indabaesori.shop', 2);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (5, null, null, '순살 양념치킨', 16000, 'https://indabaesori.shop', 'https://indabaesori.shop', 2);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (6, null, null, '순살 매운양념', 16000, 'https://indabaesori.shop', 'https://indabaesori.shop', 2);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (7, null, null, '후라이드반+양념반', 15000, 'https://indabaesori.shop', 'https://indabaesori.shop', 3);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (8, null, null, '후라이드반+매운양념반', 15000, 'https://indabaesori.shop', 'https://indabaesori.shop', 3);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (9, null, null, '후라이드반+간장반', 15000, 'https://indabaesori.shop', 'https://indabaesori.shop', 3);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (10, null, null, '알싸한 마늘치킨', 15000, 'https://indabaesori.shop', 'https://indabaesori.shop', 4);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (11, null, null, '간바치', 20000, 'https://indabaesori.shop', 'https://indabaesori.shop', 4);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (12, null, null, '고바치', 20000, 'https://indabaesori.shop', 'https://indabaesori.shop', 4);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (13, null, null, '辛3종세트（매운양념＋매운후라이드＋깐풍）', 20000, 'https://indabaesori.shop', 'https://indabaesori.shop', 5);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (14, null, null, '매콤후라이드치킨', 18000, 'https://indabaesori.shop', 'https://indabaesori.shop', 5);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (15, null, null, '후라이드치킨', 17000, 'https://indabaesori.shop', 'https://indabaesori.shop', 5);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (16, null, null, '크런치 새우 （7개）', 5000, 'https://indabaesori.shop', 'https://indabaesori.shop', 6);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (17, null, null, '모듬감자튀김', 7000, 'https://indabaesori.shop', 'https://indabaesori.shop', 6);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (18, null, null, '국물떡볶이', 7000, 'https://indabaesori.shop', 'https://indabaesori.shop', 6);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (19, null, null, '직구 싱글 도시락', 14900, 'https://indabaesori.shop', 'https://indabaesori.shop', 7);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (20, null, null, '직구 도시락', 19900, 'https://indabaesori.shop', 'https://indabaesori.shop', 7);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (21, null, null, '직구 고기만 세트', 21900, 'https://indabaesori.shop', 'https://indabaesori.shop', 8);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (22, null, null, '오삼불고기(소)', 23900, 'https://indabaesori.shop', 'https://indabaesori.shop', 9);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (23, null, null, '오삼불고기(중)', 28900, 'https://indabaesori.shop', 'https://indabaesori.shop', 9);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (24, null, null, '치킨 마크니', 11000, 'https://indabaesori.shop', 'https://indabaesori.shop', 10);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (25, null, null, '치킨 빈달루', 11500, 'https://indabaesori.shop', 'https://indabaesori.shop', 10);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (26, null, null, '비프 코르마', 11000, 'https://indabaesori.shop', 'https://indabaesori.shop', 11);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (27, null, null, '비프 티카 마살라', 11500, 'https://indabaesori.shop', 'https://indabaesori.shop', 11);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (28, null, null, '까망찜닭', 18000, 'https://indabaesori.shop', 'https://indabaesori.shop', 12);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (29, null, null, '빨강찜닭', 18000, 'https://indabaesori.shop', 'https://indabaesori.shop', 12);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (30, null, null, '공기밥', 1000, 'https://indabaesori.shop', 'https://indabaesori.shop', 13);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (31, null, null, '코카콜라', 2000, 'https://indabaesori.shop', 'https://indabaesori.shop', 14);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (32, null, null, '스프라이트', 2000, 'https://indabaesori.shop', 'https://indabaesori.shop', 14);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (33, null, null, '(신메뉴) 옛날치킨 (뼈)', 14000, 'https://indabaesori.shop', 'https://indabaesori.shop', 15);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (34, null, null, '(신메뉴) 생생소이치킨 (뼈)', 16000, 'https://indabaesori.shop', 'https://indabaesori.shop', 15);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (35, null, null, '매직버터치킨세트 (보통맛)', 21000, 'https://indabaesori.shop', 'https://indabaesori.shop', 15);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (36, null, null, '후라이드(뼈)+양념소떡', 19000, 'https://indabaesori.shop', 'https://indabaesori.shop', 16);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (37, null, null, '양념치킨(뼈)+양념소떡', 20000, 'https://indabaesori.shop', 'https://indabaesori.shop', 16);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (38, null, null, '교촌시그니처세트', 26000, 'https://indabaesori.shop', 'https://indabaesori.shop', 17);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (39, null, null, '교촌레드순살[R]', 19000, 'https://indabaesori.shop', 'https://indabaesori.shop', 18);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (40, null, null, '교촌레드스틱', 18000, 'https://indabaesori.shop', 'https://indabaesori.shop', 18);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (41, null, null, '교촌허니순살[R]', 20000, 'https://indabaesori.shop', 'https://indabaesori.shop', 19);
INSERT INTO yogiyo_toy.menu (menu_id, created_date, last_modified_date, name, price, image_url, share_url, menu_category_id) VALUES (42, null, null, '교촌허니스틱', 18000, 'https://indabaesori.shop', 'https://indabaesori.shop', 19);

INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (1, '치킨 메뉴', 1);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (2, '순살 메뉴', 1);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (3, '반반 메뉴(뼈)', 1);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (4, '신메뉴', 2);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (5, '메인 메뉴', 2);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (6, '사이드 메뉴', 2);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (7, '직구삼 BEST 메뉴', 3);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (8, '직구고기만세트 메뉴', 3);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (9, '오삼불고기 메뉴', 3);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (10, '닭고기 커리', 4);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (11, '소고기 커리', 4);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (12, '대표메뉴', 5);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (13, 'EXTRA', 5);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (14, 'DRINK', 5);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (15, '신메뉴', 6);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (16, '치킨+사이드 세트', 6);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (17, '세트메뉴', 7);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (18, '레드시리즈', 7);
INSERT INTO yogiyo_toy.menu_category (menu_category_id, name, restaurant_id) VALUES (19, '허니시리즈', 7);

INSERT INTO yogiyo_toy.option_category (option_category_id, name, menu_id) VALUES (1, '사이드 메뉴', 1);
INSERT INTO yogiyo_toy.option_category (option_category_id, name, menu_id) VALUES (2, '추가 선택 (추가선택 가능)', 1);
INSERT INTO yogiyo_toy.option_category (option_category_id, name, menu_id) VALUES (3, '추가 선택', 35);

INSERT INTO yogiyo_toy.options (option_id, name, price, option_category_id) VALUES (1, '눈꽃 치즈볼 4개', 3500, 1);
INSERT INTO yogiyo_toy.options (option_id, name, price, option_category_id) VALUES (2, '눈꽃치즈 핫도그 4개', 4000, 1);
INSERT INTO yogiyo_toy.options (option_id, name, price, option_category_id) VALUES (3, '치즈볼 4개', 3000, 1);
INSERT INTO yogiyo_toy.options (option_id, name, price, option_category_id) VALUES (4, '허니버터 치즈볼 4개', 3500, 1);
INSERT INTO yogiyo_toy.options (option_id, name, price, option_category_id) VALUES (5, '허니버터 핫도그 4개', 4000, 1);
INSERT INTO yogiyo_toy.options (option_id, name, price, option_category_id) VALUES (6, '디진다핫소스', 1000, 2);
INSERT INTO yogiyo_toy.options (option_id, name, price, option_category_id) VALUES (7, '무 추가', 500, 2);
INSERT INTO yogiyo_toy.options (option_id, name, price, option_category_id) VALUES (8, '양념소스', 500, 2);
INSERT INTO yogiyo_toy.options (option_id, name, price, option_category_id) VALUES (9, '콜라 1.25L로 변경', 1000, 2);
INSERT INTO yogiyo_toy.options (option_id, name, price, option_category_id) VALUES (10, '치킨무', 500, 3);

INSERT INTO yogiyo_toy.order_menu (order_menu_id, quantity, menu_id, order_id) VALUES (10, 1, 1, 9);
INSERT INTO yogiyo_toy.order_menu (order_menu_id, quantity, menu_id, order_id) VALUES (14, 1, 1, 13);
INSERT INTO yogiyo_toy.order_menu (order_menu_id, quantity, menu_id, order_id) VALUES (18, 1, 1, 17);
INSERT INTO yogiyo_toy.order_menu (order_menu_id, quantity, menu_id, order_id) VALUES (22, 1, 1, 21);

INSERT INTO yogiyo_toy.orders (order_id, created_date, last_modified_date, city, region, delivery_discount, delivery_price, order_number, order_type, payment_type, request, member_id, restaurant_id) VALUES (1, '2020-08-18 22:43:50', null, '인천시', '미추홀구', '2000', 1000, '200613-20-144783', '터치', '요기서 1초결제', '', 1, 6);
INSERT INTO yogiyo_toy.orders (order_id, created_date, last_modified_date, city, region, delivery_discount, delivery_price, order_number, order_type, payment_type, request, member_id, restaurant_id) VALUES (2, '2020-08-10 01:35:40', null, '인천시', '미추홀구', '2000', 1000, '200614-20-144784', '터치', '요기서 1초결제', null, 1, 6);
INSERT INTO yogiyo_toy.orders (order_id, created_date, last_modified_date, city, region, delivery_discount, delivery_price, order_number, order_type, payment_type, request, member_id, restaurant_id) VALUES (3, '2020-08-10 03:00:10', null, '인천시', '미추홀구', '2000', 1000, '200617-20-168453', '터치', '요기서 1초결제', null, 2, 1);
INSERT INTO yogiyo_toy.orders (order_id, created_date, last_modified_date, city, region, delivery_discount, delivery_price, order_number, order_type, payment_type, request, member_id, restaurant_id) VALUES (4, '2020-08-10 03:00:10', null, '인천시', '미추홀구', '0', 1000, '200619-20-156842', '터치', '요기서 1초결제', null, 1, 1);
INSERT INTO yogiyo_toy.orders (order_id, created_date, last_modified_date, city, region, delivery_discount, delivery_price, order_number, order_type, payment_type, request, member_id, restaurant_id) VALUES (5, '2020-08-10 03:00:10', null, '인천시', '미추홀구', '0', 1000, '200623-20-153215', '전화', '요기서 1초결제', '빨리 갖다주세요', 1, 1);
INSERT INTO yogiyo_toy.orders (order_id, created_date, last_modified_date, city, region, delivery_discount, delivery_price, order_number, order_type, payment_type, request, member_id, restaurant_id) VALUES (6, '2020-08-12 01:36:42', null, '인천시', '미추홀구', '2000', 1000, '200711-20-135489', '터치', '요기서 1초결제', '빨리 갖다주세요', 4, 6);
INSERT INTO yogiyo_toy.orders (order_id, created_date, last_modified_date, city, region, delivery_discount, delivery_price, order_number, order_type, payment_type, request, member_id, restaurant_id) VALUES (7, '2020-08-12 01:56:03', null, '인천시', '미추홀구', '2000', 1000, '200714-20-159123', '전화', '요기서 1초결제', '빨리 갖다주세요', 1, 6);
INSERT INTO yogiyo_toy.orders (order_id, created_date, last_modified_date, city, region, delivery_discount, delivery_price, order_number, order_type, payment_type, request, member_id, restaurant_id) VALUES (9, '2021-01-25 15:57:36', '2021-01-25 15:57:36', '인천', '미추홀구', '3000', 2000, null, 'call', 'cash', '', null, 1);
INSERT INTO yogiyo_toy.orders (order_id, created_date, last_modified_date, city, region, delivery_discount, delivery_price, order_number, order_type, payment_type, request, member_id, restaurant_id) VALUES (13, '2021-01-25 15:57:39', '2021-01-25 15:57:39', '인천', '미추홀구', '3000', 2000, null, 'call', 'cash', '', null, 1);
INSERT INTO yogiyo_toy.orders (order_id, created_date, last_modified_date, city, region, delivery_discount, delivery_price, order_number, order_type, payment_type, request, member_id, restaurant_id) VALUES (17, '2021-01-25 15:57:42', '2021-01-25 15:57:42', '인천', '미추홀구', '3000', 2000, null, 'call', 'cash', '', null, 1);
INSERT INTO yogiyo_toy.orders (order_id, created_date, last_modified_date, city, region, delivery_discount, delivery_price, order_number, order_type, payment_type, request, member_id, restaurant_id) VALUES (21, '2021-01-25 15:57:44', '2021-01-25 15:57:44', '인천', '미추홀구', '3000', 2000, null, 'call', 'cash', '', null, 1);

INSERT INTO yogiyo_toy.restaurant (restaurant_id, city, region, background_url, delivery_price, delivery_discount, discount_rate, min_deliverable_price, name, card, cash, online, business_hours, business_registration_number, is_best, is_cesco, is_deliver, is_our_village_plus, is_super_red_week, is_yogiyo_plus, notice, origin, phone, image_url, share_url) VALUES (1, '용현동 344-1', '인천시 미추홀구', 'https://indabaesori.shop', 2000, 3000, 0, 14000, '후라이드참잘하는집-인하대점', 'Y', 'Y', 'Y', '11:00 - 02:30', '231-15-00743', 'Y', 'N', 'Y', 'N', 'Y', 'Y', '뼈있는 치킨 : 닭(국내산) *순살치킨 : 닭고기(브라질산) *주인장:(국내산) *직원 및 점장:(국내산) 배달기사님들 : (국내산)', '뼈있는 치킨 : 닭(국내산) *순살치킨 : 닭고기(브라질산) *주인장:(국내산) *직원 및 점장:(국내산) 배달기사님들 : (국내산)', '050712918725', 'https://indabaesori.shop', 'https://indabaesori.shop');
INSERT INTO yogiyo_toy.restaurant (restaurant_id, city, region, background_url, delivery_price, delivery_discount, discount_rate, min_deliverable_price, name, card, cash, online, business_hours, business_registration_number, is_best, is_cesco, is_deliver, is_our_village_plus, is_super_red_week, is_yogiyo_plus, notice, origin, phone, image_url, share_url) VALUES (2, '용현동 182-21', '인천시 미추홀구', 'https://indabaesori.shop', 0, 0, 0, 17000, '노랑통닭-인하대점', 'Y', 'Y', 'Y', '15:00 - 01:20', '499-64-00124', 'N', 'N', 'Y', 'N', 'N', 'N', '뼈: 국내산
정육:브라질산
근위:국내산
닭누룽지탕:국내산
오징어 쥐포:국내산', '뼈: 국내산
정육:브라질산
근위:국내산
닭누룽지탕:국내산
오징어 쥐포:국내산', '050712918191', 'https://indabaesori.shop', 'https://indabaesori.shop');
INSERT INTO yogiyo_toy.restaurant (restaurant_id, city, region, background_url, delivery_price, delivery_discount, discount_rate, min_deliverable_price, name, card, cash, online, business_hours, business_registration_number, is_best, is_cesco, is_deliver, is_our_village_plus, is_super_red_week, is_yogiyo_plus, notice, origin, phone, image_url, share_url) VALUES (3, '주안동 1282-7', '인천시 미추홀구', 'https://indabaesori.shop', 2000, 2000, 0, 12000, '배달삼겹직구삼-주안점', 'Y', 'Y', 'Y', '07:00 - 06:59', '568-16-00680', 'N', 'N', 'Y', 'Y', 'N', 'N', '*삼겹살: 독일산
*목살: 스페인산
*불고기: 스페인산
*소시지: 미국산
*쌀: 미국산
*오징어: 칠레산
*치즈: 뉴질랜드산,미국산
*김치: 중국산
*고춧가루: 중국산
*마늘 : 국내산
*고추 : 국내산', '*삼겹살: 독일산
*목살: 스페인산
*불고기: 스페인산
*소시지: 미국산
*쌀: 미국산
*오징어: 칠레산
*치즈: 뉴질랜드산,미국산
*김치: 중국산
*고춧가루: 중국산
*마늘 : 국내산
*고추 : 국내산', '050712921175', 'https://indabaesori.shop', 'https://indabaesori.shop');
INSERT INTO yogiyo_toy.restaurant (restaurant_id, city, region, background_url, delivery_price, delivery_discount, discount_rate, min_deliverable_price, name, card, cash, online, business_hours, business_registration_number, is_best, is_cesco, is_deliver, is_our_village_plus, is_super_red_week, is_yogiyo_plus, notice, origin, phone, image_url, share_url) VALUES (4, '용현동 199-8', '인천시 미추홀구', 'https://indabaesori.shop', 4300, 1800, 0, 11000, '커리야 인하대점', 'Y', 'N', 'Y', '매일 오전 11시 ~ 오후 9시', '228-04-62091', 'N', 'N', 'N', 'N', 'N', 'Y', '쌀 미국산 생닭 국내산(탄두리치킨)', '쌀 미국산 생닭 국내산(탄두리치킨)', '1688-2263', 'https://indabaesori.shop', 'https://indabaesori.shop');
INSERT INTO yogiyo_toy.restaurant (restaurant_id, city, region, background_url, delivery_price, delivery_discount, discount_rate, min_deliverable_price, name, card, cash, online, business_hours, business_registration_number, is_best, is_cesco, is_deliver, is_our_village_plus, is_super_red_week, is_yogiyo_plus, notice, origin, phone, image_url, share_url) VALUES (5, '용현동 188-16', '인천시 미추홀구', 'https://indabaesori.shop', 0, 1800, 0, 18000, '치즈를사랑한찜닭', 'Y', 'N', 'Y', '매일 오전 10시 ~ 오후 9시 40분', '121-22-73156', 'N', 'N', 'N', 'N', 'N', 'Y', '', '', '1688-2263', 'https://indabaesori.shop', 'https://indabaesori.shop');
INSERT INTO yogiyo_toy.restaurant (restaurant_id, city, region, background_url, delivery_price, delivery_discount, discount_rate, min_deliverable_price, name, card, cash, online, business_hours, business_registration_number, is_best, is_cesco, is_deliver, is_our_village_plus, is_super_red_week, is_yogiyo_plus, notice, origin, phone, image_url, share_url) VALUES (6, '학익동 413-9', '인천시 미추홀구', 'https://indabaesori.shop', 1000, 2000, 0, 15000, '3가지맛디디치킨-인하대점', 'Y', 'Y', 'Y', '매일 오후 3시 ~ 다음날 오전 2시', '674-31-00561', 'N', 'N', 'Y', 'Y', 'N', 'N', '계육-국내산 근위-국내산 웨지감자-벨기에산 새우링-베트남산', '계육-국내산 근위-국내산 웨지감자-벨기에산 새우링-베트남산', '050712944517', 'https://indabaesori.shop', 'https://indabaesori.shop');
INSERT INTO yogiyo_toy.restaurant (restaurant_id, city, region, background_url, delivery_price, delivery_discount, discount_rate, min_deliverable_price, name, card, cash, online, business_hours, business_registration_number, is_best, is_cesco, is_deliver, is_our_village_plus, is_super_red_week, is_yogiyo_plus, notice, origin, phone, image_url, share_url) VALUES (7, '학익동 665-3', '인천시 미추홀구', 'https://indabaesori.shop', 2000, 0, 0, 15000, '교촌치킨-학익1호점', 'Y', 'Y', 'Y', '11:00 - 03:00', '221-34-50683', 'N', 'N', 'Y', 'Y', 'N', 'N', '닭고기 : 국내산

감자: 미국산

쌀(볶음밥): 국내산

채소(샐러드): 국내산', '닭고기 : 국내산

감자: 미국산

쌀(볶음밥): 국내산

채소(샐러드): 국내산', '050352596479', 'https://indabaesori.shop', 'https://indabaesori.shop');

INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (1, 3, 1);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (2, 3, 2);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (3, 6, 3);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (4, 4, 4);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (5, 6, 5);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (6, 3, 6);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (7, 3, 7);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (8, 6, 8);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (9, 2, 1);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (10, 9, 1);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (11, 2, 2);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (12, 9, 2);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (13, 2, 3);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (14, 2, 4);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (15, 2, 6);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (16, 9, 6);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (17, 2, 7);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (18, 9, 7);
INSERT INTO yogiyo_toy.restaurant_category (restaurant_category_id, category_id, restaurant_id) VALUES (19, 2, 8);

INSERT INTO yogiyo_toy.review (review_id, created_date, last_modified_date, avg_score, contents, delivery, quantity, taste, order_id, restaurant_id) VALUES (1, '2020-08-24 02:16:40', null, 5, '배달도 빠르고 아이들이 좋아해요', 5, 5, 5, 1, 6);
INSERT INTO yogiyo_toy.review (review_id, created_date, last_modified_date, avg_score, contents, delivery, quantity, taste, order_id, restaurant_id) VALUES (2, '2020-08-24 02:35:40', null, 4.6, '항상 맛나고 배송이 빨라요', 5, 4, 5, 2, 6);
INSERT INTO yogiyo_toy.review (review_id, created_date, last_modified_date, avg_score, contents, delivery, quantity, taste, order_id, restaurant_id) VALUES (3, '2020-08-12 09:56:03', null, 3.3, '맛있어요 ^^ 배달은 좀 오래 걸렸어요 ㅠㅠ', 3, 2, 5, 3, 1);
INSERT INTO yogiyo_toy.review (review_id, created_date, last_modified_date, avg_score, contents, delivery, quantity, taste, order_id, restaurant_id) VALUES (4, '2020-08-24 03:02:34', null, 5, '굿', 5, 5, 5, 4, 1);
INSERT INTO yogiyo_toy.review (review_id, created_date, last_modified_date, avg_score, contents, delivery, quantity, taste, order_id, restaurant_id) VALUES (5, '2020-08-06 02:17:02', null, 4.3, '평소에 안그랬던거같은데 뻑뻑살이 대부분이고 뭔가 신맛이 났습니다', 5, 5, 3, 5, 1);