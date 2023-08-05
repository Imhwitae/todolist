package com.todo.todolist.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
    @Column(columnDefinition = "boolean default 0")
    private Boolean secession; //탈퇴여부

    @Builder
    public Members(String loginId, String password, String name, Boolean secession) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.secession = secession;
    }
}
