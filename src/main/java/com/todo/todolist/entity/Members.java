package com.todo.todolist.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membersId;

    @NotEmpty
    private String loginId; //로그인 ID
    @NotEmpty
    private String password;
    @NotEmpty
    private String name; //사용자 이름
    @NotEmpty
    private String secession; //탈퇴여부

    @Builder
    public Members(String loginId, String password, String name, String secession) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.secession = secession;
    }
}
