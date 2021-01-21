package practice.yogiyo.entity.Member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.yogiyo.entity.EmbeddedType.Address;
import practice.yogiyo.entity.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name= "member_id")
    private Long id;

    private String email;
    private String nickname;
    private String password;
    private String phone;
    private String paymentPassword;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    public Member(String email, String nickname, String password, String phone) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
        this.memberType = MemberType.FAMILY;
    }
}

