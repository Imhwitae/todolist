package com.todo.todolist.dto;

import com.todo.todolist.entity.Members;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembersDto {
    private Long membersId;
    private String loginId;
    private String password;
    private String name;
    private String secession;

    public MembersDto(Long membersId, String loginId, String password, String name, String secession) {
        this.membersId = membersId;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.secession = secession;
    }

    public Members toEntity(){
        return new Members(membersId,loginId,password,name,secession);
    }
}
