package com.todo.todolist.service;

import com.todo.todolist.dto.request.ListsSaveDto;
import com.todo.todolist.entity.BaseTimeEntity;
import com.todo.todolist.entity.Lists;
import com.todo.todolist.repository.ListsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListsService {
    private final ListsRepository listsRepository;
    // 리스트 작성
    public Long listSave(ListsSaveDto listsSaveDto) {
        Lists lists = Lists.builder()
                .listPeriod(listsSaveDto.getListPeriod())
                .listContent(listsSaveDto.getListContent())
                .build();

        listsRepository.save(lists);

        return lists.getListNo();
    }

}
