package practice.yogiyo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import practice.yogiyo.LoginForm;
import practice.yogiyo.MemberForm;

import practice.yogiyo.dto.CategoryDto;
import practice.yogiyo.dto.MemberDto;
import practice.yogiyo.entity.Member.Member;
import practice.yogiyo.entity.Restaurant.Category;
import practice.yogiyo.service.CategoryService;
import practice.yogiyo.service.MemberService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final CategoryService categoryService;

    @RequestMapping("/")
    public String home(Model model) {
        List<Category> categories = categoryService.findCategories();
        List<CategoryDto> categoryDtos = categories.stream()
                .map(c -> new CategoryDto(c.getId(), categoryService.toKoeran(c.getRestaurantType())))
                .collect(Collectors.toList());

        model.addAttribute("categoryDtos", categoryDtos);
        return "home";
    }

    // 필요한 정보만 가져오기 위해서 Member 대신 MemberForm 사용
    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createMember(@Valid MemberForm form, BindingResult result) {
        // 정보 비었으면 오류 메시지 가지고 돌아감
        if (result.hasErrors()) {
            return "members/createMemberForm";
        }
        Member member = new Member(form.getEmail(), form.getNickname(), form.getPassword(), form.getPhone());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String getMembers(Model model) {
        List<Member> members = memberService.findMembers();
        List<MemberDto> memberDtos = members.stream()
                .map(m -> new MemberDto(m.getId(), m.getEmail(), m.getNickname(), m.getPhone(), m.getMemberType()))
                .collect(Collectors.toList());
        model.addAttribute("memberDtos", memberDtos);
        return "members/memberList";
    }

    @GetMapping("/login")
    public String createLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "members/LoginForm";
    }
}
