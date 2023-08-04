package com.todo.todolist.controller;

import com.todo.todolist.entity.Members;
import com.todo.todolist.repository.MembersRepository;
import com.todo.todolist.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MembersController {
    private final MembersRepository membersRepository;
    private final MemberService memberService;

    @GetMapping("/")
    public String signUpForm(@ModelAttribute("members") Members members){
        return "member/signUp";
    }

    @PostMapping("/add")
    public String singUp(@ModelAttribute("members") Members members, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "member/signUp";
        }
        memberService.join(members);
        return "member/login";
    }

}
