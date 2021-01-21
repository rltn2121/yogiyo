package practice.yogiyo.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.yogiyo.entity.Member.Member;
import practice.yogiyo.repository.MemberRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Test
    public void join() throws Exception{
        // given
        String email = "asd@Asd.com";
        String password = "1234";
        String nickname = "haha";
        String phone = "01012341234";
        Member member = new Member(email, password, nickname, phone);

        // when
        Long savedId = memberService.join(member);

        // then
        Assertions.assertThat(savedId).isEqualTo(member.getId());
    }
}