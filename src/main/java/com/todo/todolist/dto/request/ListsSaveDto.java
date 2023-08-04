package com.todo.todolist.dto.request;

import com.todo.todolist.entity.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ListsSaveDto {
    private String listContent;
    private LocalDate listPeriod;
    private boolean listCompleted;
    private Long memberNo;
}
