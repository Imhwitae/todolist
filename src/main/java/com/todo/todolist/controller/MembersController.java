package com.todo.todolist.controller;

import com.todo.todolist.entity.Members;
import com.todo.todolist.repository.MembersRepository;
import com.todo.todolist.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MembersController {
    private final MembersRepository membersRepository;
    private final MemberService memberService;

    @PostMapping("/add")
    public String singUp(@Valid @ModelAttribute("members") Members members, BindingResult bindingResult){
        memberService.join(members);
        if (memberService.join(members) == members.getMembersId()){
            return "member/message";
        }
        return "member/login";
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute("loginForm") MemLoginDto memLoginDto){
//        if
//    }
}
