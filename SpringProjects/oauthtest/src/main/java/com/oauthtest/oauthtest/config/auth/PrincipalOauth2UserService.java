package com.oauthtest.oauthtest.config.auth;


import com.oauthtest.oauthtest.entity.Member;
import com.oauthtest.oauthtest.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String provider = userRequest.getClientRegistration().getClientId();
        String providerId = oAuth2User.getAttribute("sub");
        String username = oAuth2User.getAttribute("name");
        String email = oAuth2User.getAttribute("email");
        String roles = "ROLE_USER";

        Member memberEntity = memberRepository.findByUsername(username);

        //memberEntity 가 null값일 경우 회원이 없는 경우 즉, 처음 로그인한 경우 이기 때문에 회원 가입 처리를 해준다.
        //null이 아닌경우 기존에 로그인한 기록이 있기 때문에 따로 처리 안해준다.
        if(memberEntity == null){
            memberEntity = Member.builder()
                    .username(username)
                    .email(email)
                    .roles(roles)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            memberRepository.save(memberEntity);
        }

        return new PrincipalDetails(memberEntity,oAuth2User.getAttributes());
    }
}
