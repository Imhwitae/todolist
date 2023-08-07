package com.todo.todolist.dto.response;

import com.todo.todolist.entity.Members;
import lombok.*;

@Getter
@Setter
public class MembersDto {
    private Long membersId;
    private String email;
    private String password;
    private String name;
    private Boolean secession;

    public MembersDto(String email, String password, String name, Boolean secession) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.secession = secession;
    }

    public Members toEntity(){
        return Members.builder()
                .email(email)
                .name(name)
                .password(password)
                .secession(secession).build();
    }
}
