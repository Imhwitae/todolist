package com.todo.todolist.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
public class Lists extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_no", nullable = false)
    private Long listNo;

    @Column(name = "list_content", nullable = false)
    private String listContent;

//    @Column(name = "list_period", nullable = false)
//    private LocalDate listPeriod;  // 기간

    @Column(name = "list_completed", columnDefinition = "TINYINT default 0")
    private boolean listCompleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "members_id", nullable = false)
    private Members members;

    @Builder
    public Lists(String listContent, LocalDate listPeriod, boolean listCompleted, Members members) {
        this.listContent = listContent;
        this.listCompleted = listCompleted;
        this.members = members;
    }
}
