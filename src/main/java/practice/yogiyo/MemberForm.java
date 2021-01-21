package practice.yogiyo;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberForm {

    @NotEmpty(message = "이메일을 입력하세요.")
    private String email;
    @NotEmpty(message = "비밀번호를 입력하세요.")
    private String password;
    @NotEmpty(message = "닉네임을 입력하세요.")
    private String nickname;
    @NotEmpty(message = "전화번호를 입력하세요.")
    private String phone;
}
