package com.todo.todolist.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class Lists extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_no", nullable = false)
    private Long listNo;

    @Column(name = "list_content", nullable = false)
    private String listContent;

    @Column(name = "list_period", nullable = false)
    private LocalDate listPeriod;

    @Column(name = "list_completed")
    private boolean listCompleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "members_id", nullable = false)
    private Members members;
}
