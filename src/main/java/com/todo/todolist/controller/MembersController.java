package com.todo.todolist.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.todolist.config.auth.OAuthToken;
import com.todo.todolist.config.auth.SessionMember;
import com.todo.todolist.domain.user.Role;
import com.todo.todolist.dto.response.KakaoProfile;
import com.todo.todolist.entity.Members;
import com.todo.todolist.repository.MembersRepository;
import com.todo.todolist.service.MemberService;
import com.todo.todolist.util.KakaoToken;
import com.todo.todolist.util.KakaoUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
//@RequestMapping("/members")
@RequiredArgsConstructor
public class MembersController {
    private final MemberService memberService;
    private final KakaoToken kakaoToken;
    private final KakaoUserInfo kakaoUserInfo;

//    @PostMapping("/")
//    public String singUp(@Valid @ModelAttribute("members") Members members, BindingResult bindingResult){
//        memberService.join(members);
//        if (memberService.join(members) == members.getMembersId()){
//            return "member/message";
//        }
//        return "/";
//    }

    @GetMapping("/kakao/login")
    public String kakaoCallback(String code, Model model) {

        OAuthToken oAuthToken = kakaoToken.getToken(code);

        System.out.println("카카오 엑세스 토큰 : "+ oAuthToken.getAccess_token());

        Members kakaoProfile = kakaoUserInfo.getUserInfo(oAuthToken);

        System.out.println("kakao이메일 = " + kakaoProfile.getEmail());

        try {
            memberService.join(kakaoProfile);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "member/message";
        }

        return "member/message3";
    }

    @GetMapping("/kakao/index")
    public String index(){
        return "index";
    }



}
