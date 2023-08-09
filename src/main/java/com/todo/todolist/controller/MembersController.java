package com.todo.todolist.controller;

import com.todo.todolist.repository.MembersRepository;
import com.todo.todolist.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class MembersController {
    private final MembersRepository membersRepository;
    private final MemberService memberService;

//    @PostMapping("/")
//    public String singUp(@Valid @ModelAttribute("members") Members members, BindingResult bindingResult){
//        memberService.join(members);
//        if (memberService.join(members) == members.getMembersId()){
//            return "member/message";
//        }
//        return "/";
//    }

    /**
     * 유저 소셜 로그인으로 리다이렉트 해주는 url
     * [GET] /accounts/auth
     * @return void
     */

}
