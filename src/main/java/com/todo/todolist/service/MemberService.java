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
        membersRepository.save(members);
        return members.getMembersId();
    }
}
