package com.todo.todolist.controller;

import com.todo.todolist.config.auth.SessionMember;
import com.todo.todolist.dto.request.MemLoginDto;
import com.todo.todolist.entity.Members;
import com.todo.todolist.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final HttpSession httpSession;
    private final LoginService loginService;

//    @GetMapping
//    public String signUpForm(@ModelAttribute("members") Members members,
//                             @ModelAttribute("loginForm") MemLoginDto memLoginDto){
//        return "/member/login";
//    }

    @GetMapping
    public String loginPage() {
        return "index";
    }

    @GetMapping("/kakao")
    public String kakaoLogin(){
        return "kakaologin";
    }

//    @PostMapping
//    public String mainPage(Model model) {
//        SessionMember member = (SessionMember) httpSession.getAttribute("member");
//
//        model.getAttribute(member.getEmail());
//
//        if (member == null) {
//            return "redirect:/";
//        }
//
//        return "/todo_main";
//    }
}

