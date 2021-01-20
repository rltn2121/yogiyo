package practice.yogiyo.entity;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name="memberId")
    private Long id;

    private String email;
    private String name;
    private String nickname;
    private String password;
    private String phone;
    private String paymentPassword;

    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private MemberType memberType;
}

