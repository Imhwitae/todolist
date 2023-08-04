package com.todo.todolist.repository;

import com.todo.todolist.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembersRepository extends JpaRepository<Members, Long> {
    List<Members> findByLoginId(String LoginId);
}
