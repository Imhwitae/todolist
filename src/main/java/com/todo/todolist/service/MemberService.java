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
        validateDuplicateMembers(members);
        membersRepository.save(members);
        return members.getMembersId();
    }

    private void validateDuplicateMembers(Members members){
        List<Members> findMember = membersRepository.findByLoginId(members.getLoginId());
        if (!findMember.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }
}
