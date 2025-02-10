package com.example.schedule_crud.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final String title;
    private final String todo;
    private final String username;


    public ScheduleResponseDto(Long id, String title, String todo, String username) {
        this.id = id;
        this.title = title;
        this.todo = todo;
        this.username = username;
    }
}
