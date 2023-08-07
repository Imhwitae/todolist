package com.todo.todolist.config.auth;

import com.todo.todolist.entity.Members;
import com.todo.todolist.repository.MembersRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collections;

@RequiredArgsConstructor
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final MembersRepository membersRepository;
    private final HttpSession httpSession;

    /**
     * 구글 로그인 이후 가져온 사용자의 정보를 기반으로 가입 및 수정, 세션 저장 등의 기능 지원
     *
     * registrationId: 현재 로그인 중인 서비스를 구분하는 코드(여러 소셜 로그인 서비스를 연동할 때 네이버인지, 구글인지 구분하기 위함)
     * userNameAttributeName: OAuth2 로그인 진행 시 키가 되는 필드값(primary key와 같은 의미)
     *                        구글은 기본적으로 코드 제공, 네이버나 카카오는 기본 제공 X
     *                        이후 네이버와 구글 로그인을 동시 지원할 때 사용
     * OAuthAttributes: OAuth2UserService를 통해 가져온 OAuth2User의 attribute를 담을 클래스
     *
     * @param userRequest the user request
     * @return
     * @throws OAuth2AuthenticationException
     */
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        Members member = saveOrUpdate(attributes);

        httpSession.setAttribute("member", new SessionMember(member));

        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(member.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }

    private Members saveOrUpdate(OAuthAttributes attributes) {
        Members member = membersRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
                .orElse(attributes.toEntity());

        return membersRepository.save(member);
    }
}
