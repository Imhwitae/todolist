package com.todo.todolist.controller;

import com.todo.todolist.dto.request.ListsSaveDto;
import com.todo.todolist.service.ListsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class ListsController {
    private final ListsService listService;

    @PostMapping("/add")  // 리스트 작성
    public Long addList(@RequestBody ListsSaveDto listsSaveDto) {
        return listService.listSave(listsSaveDto);
    }
}
