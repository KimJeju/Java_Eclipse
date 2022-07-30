package com.oauthtest.oauthtest.controller;


import com.oauthtest.oauthtest.config.SecurityConfig;
import com.oauthtest.oauthtest.config.auth.PrincipalDetails;
import com.oauthtest.oauthtest.entity.Member;
import com.oauthtest.oauthtest.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private MemberRepository memberRepository;


    @Autowired
    SecurityConfig config;


    @GetMapping("/")
    public @ResponseBody String index(){
        return "index";
    }


    @GetMapping("/user")
    public @ResponseBody String user(){
        return "user";
    }


    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }



    @GetMapping("/info")
    @Secured("ROLE_ADMIN")
    public String info(){
        return "info";
    }
    @GetMapping("/data")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
    public String data(){
        return "data";
    }

    @GetMapping("/login")
    public  String login(){
        return "loginForm";
    }

    @GetMapping("/loginTest") //로그인 정보가져오기
    public @ResponseBody String loginTest(Authentication authentication){
        System.out.println("===========loginTest===========");
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("authentication = " + principalDetails.getMember());
        return "세션 정보 확인";
    }

    @GetMapping("/loginTest2")
    public @ResponseBody String loginTest2(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("===========loginTest2===========");
        System.out.println("userDetails = " + principalDetails.getMember());

        return "세션 정보 확인2";
    }

    @GetMapping("/loginTest3") //oauth 로그인 정보 가져오기
    public @ResponseBody String loginOauthTest(Authentication authentication,
                                               @AuthenticationPrincipal OAuth2User oauth){
        System.out.println("===========loginOauthTest===========");
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        System.out.println("authentication = " + oAuth2User.getAttributes());
        System.out.println("oAuth2User = " + oauth.getAttributes());

        return "세션 정보 확인 3";


    }

    @GetMapping("/join")
    public String join(){
        return "joinForm";
    }

    @PostMapping("/join") //회원가입 메서드
    public String join(Member member){
        member.setRoles("ROLE_USER");
        String rawPassword = member.getPassword(); //기존 패스워드 가져오기
        String encPassword = config.bCryptPasswordEncoder().encode(rawPassword); //패스워드 암호화 인코딩
        member.setPassword(encPassword); //암호화 인코딩 set 해주기


        memberRepository.save(member);
        return "redirect:/login";
    }

}
