package com.todo.todolist.repository;

import com.todo.todolist.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Members,Long> {
}
