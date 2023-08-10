package com.todo.todolist.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.todolist.config.auth.OAuthToken;
import com.todo.todolist.domain.user.Role;
import com.todo.todolist.dto.response.KakaoProfile;
import com.todo.todolist.entity.Members;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class KakaoUserInfo {

    private OAuthToken oAuthToken;

    public Members getUserInfo(OAuthToken oAuthToken) {
        RestTemplate rt2 = new RestTemplate();

        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Authorization","Bearer "+oAuthToken.getAccess_token());
        headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest2 = new HttpEntity<>(headers2);

        // POST 방식으로 Http 요청한다. 그리고 response 변수의 응답 받는다.
        ResponseEntity<String> response2 = rt2.exchange(
                "https://kapi.kakao.com/v2/user/me", // https://{요청할 서버 주소}
                HttpMethod.POST, // 요청할 방식
                kakaoProfileRequest2,// 요청할 때 보낼 데이터
                String.class // 요청 시 반환되는 데이터 타입
        );

        ObjectMapper objectMapper2 = new ObjectMapper();
        KakaoProfile kakaoProfile = null;
        try {
            kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Members members = Members.builder()
                .name(kakaoProfile.getProperties().getNickname())
                .email(kakaoProfile.getKakao_account().getEmail())
                .picture(kakaoProfile.getProperties().getProfile_image())
                .role(Role.USER)
                .secession(true)
                .build();

        return members;
    };
}
