package com.todo.todolist.service;

import com.todo.todolist.entity.Members;
import com.todo.todolist.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MembersRepository membersRepository;

    public Long join(Members members){
        Members findMember = membersRepository.findByEmail(members.getEmail())
                .orElse(null);
        if (findMember != null){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
        membersRepository.save(members);
        return members.getMembersId();
    }
}
