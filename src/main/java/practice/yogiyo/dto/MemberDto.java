package practice.yogiyo.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import practice.yogiyo.entity.Member.MemberType;

@Getter
public class MemberDto {
    private Long id;
    private String email;
    private String nickname;
    private String phone;
    private String memberType;

    @QueryProjection
    public MemberDto(Long id, String email, String nickname, String phone, MemberType memberType) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.memberType = getMemberType(memberType);
        System.out.println("memberType = " + memberType);
    }

    private String getMemberType(MemberType memberType) {
        String type = "";
        switch (memberType) {
            case FRIEND:
                type = "저기프랜드";
                break;
            case FAMILY:
                type = "저기패밀리";
                break;
            case VIP:
                type = "저기VIP";
                break;
            case HERO:
                type = "저기히어로";
                break;
            case MASTER:
                type = "저기마스터";
                break;
        }
        return type;
    }
}
