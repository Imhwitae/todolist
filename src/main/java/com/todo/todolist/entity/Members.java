package com.todo.todolist.entity;

import com.todo.todolist.domain.user.Role;
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
    private String email; //로그인 ID
    @NotEmpty
    private String password;
    @NotEmpty
    private String name; //사용자 이름
    private String picture;
    @NotEmpty
    private Boolean secession; //탈퇴여부
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;  // 사용자의 권한

    @Builder
    public Members(String email, String password, String name, Boolean secession, Role role, String picture) {
        this.email = email;
        this.name = name;
        this.role = role;
        this.picture = picture;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    public Members update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }
}
