package com.todo.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Lists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

}
