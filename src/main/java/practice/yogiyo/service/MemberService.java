package practice.yogiyo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.yogiyo.entity.Member.Member;
import practice.yogiyo.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    public Optional<Member> findById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    private void validateMember(Member member) {
        List<Member> sameEmail = memberRepository.findByEmail(member.getEmail());
        if (!sameEmail.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }
        List<Member> sameNickname = memberRepository.findByNickname(member.getNickname());
        if (!sameNickname.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        }
    }
}
