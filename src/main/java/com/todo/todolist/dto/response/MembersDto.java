package com.todo.todolist.dto.response;

import com.todo.todolist.entity.Members;
import lombok.*;

@Getter
@Setter
public class MembersDto {
    private Long membersId;
    private String loginId;
    private String password;
    private String name;
    private Boolean secession;

    public MembersDto(String loginId, String password, String name, Boolean secession) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.secession = secession;
    }

    public Members toEntity(){
        return Members.builder()
                .loginId(loginId)
                .name(name)
                .password(password)
                .secession(secession).build();
    }
}
