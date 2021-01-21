package practice.yogiyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.yogiyo.entity.Member.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository <Member, Long> {
    List<Member> findByNickname(String name);
    List<Member> findByEmail(String email);
}
