package com.todo.todolist.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MemLoginDto {
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
