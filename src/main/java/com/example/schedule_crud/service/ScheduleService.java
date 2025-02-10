package com.example.schedule_crud.service;

import com.example.schedule_crud.dto.ScheduleRequestDto;
import com.example.schedule_crud.dto.ScheduleResponseDto;
import com.example.schedule_crud.entity.Schedule;
import com.example.schedule_crud.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto.getTitle(), dto.getTodo(), dto.getUsername());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getTodo(), savedSchedule.getUsername());
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        List<ScheduleResponseDto> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            dtos.add(new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getTodo(), schedule.getUsername()));
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 스케줄이 존재하지 않습니다.")
        );
        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getTodo(), schedule.getUsername());
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleResponseDto dto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 스케줄이 존재하지 않습니다.")
        );

        schedule.update(dto.getTitle(),dto.getTodo());
        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getTodo(), schedule.getUsername());
    }

    @Transactional
    public void deleteById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 스케줄이 존재하지 않습니다.")
        );
        scheduleRepository.deleteById(id);
    }
}
