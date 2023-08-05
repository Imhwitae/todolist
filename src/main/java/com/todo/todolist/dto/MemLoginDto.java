package com.todo.todolist.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MemLoginDto {
    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;
}
