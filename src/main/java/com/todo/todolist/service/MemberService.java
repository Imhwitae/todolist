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
        validateDuplicateMember(members);
        membersRepository.save(members);
        return members.getMembersId();
    }

    private void validateDuplicateMember(Members member) {
        Members findMember = membersRepository.findByEmail(member.getEmail())
                .orElse(null);;
        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
