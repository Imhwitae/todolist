package com.todo.todolist.service;

import java.util.List;
import java.util.Optional;

//import com.todo.todolist.config.auth.SessionMember;
import com.todo.todolist.entity.Members;
import com.todo.todolist.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MembersRepository membersRepository;

//    public Members login(String loginId, String password){
//        List<Members> loginMember =  membersRepository.findByLoginId(loginId);
//
//        if (loginMember.contains(password)){
//
//        }
//    }


//    public String googleLogin(SessionMember member) {
//        // String.valueOf(): 만약 값이 null이라면 그냥 문자열 null로 표기
//        String memberEmail = String.valueOf(membersRepository.findByEmail(member.getEmail()));
//
//
//    }
}
