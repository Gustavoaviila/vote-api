package com.voteapi.service;

import com.voteapi.entity.Schedule;
import com.voteapi.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;


    public Schedule createSchedule (Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public Schedule getScheduleById(Integer idSchedule) {
        return scheduleRepository.findById(idSchedule).orElse(null);
    }

    public Schedule getScheduleByName(String nameSchedule) {
        return scheduleRepository.findByName(nameSchedule).orElse(null);
    }
}
