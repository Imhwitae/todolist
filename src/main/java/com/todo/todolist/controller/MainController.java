package com.todo.todolist.controller;

import com.todo.todolist.dto.MemLoginDto;
import com.todo.todolist.entity.Members;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String signUpForm(@ModelAttribute("members") Members members,
                             @ModelAttribute("loginForm") MemLoginDto memLoginDto){
        return "member/login";
    }
}

