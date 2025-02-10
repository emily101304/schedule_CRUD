package com.example.schedule_crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String todo;
    private String username;

    public Schedule(String title, String todo, String username) {
        this.title = title;
        this.todo = todo;
        this.username = username;
    }

    public void update(String title, String todo) {
        this.title = title;
        this.todo = todo;
    }
}
