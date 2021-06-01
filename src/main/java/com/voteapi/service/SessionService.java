package com.voteapi.service;

import com.voteapi.controller.Dto.SessionDto;
import com.voteapi.entity.Schedule;
import com.voteapi.entity.Session;
import com.voteapi.repository.ScheduleRepository;
import com.voteapi.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;


@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    static final long ONE_MINUTE_IN_MILLIS=60000;//millisecs

    public Session createSession(SessionDto sessionDto) {

        Calendar date = Calendar.getInstance();
        Date afterAddingOneMin=new Date(sessionDto.getStartDate().getTime() + (1 * ONE_MINUTE_IN_MILLIS));

        if (sessionDto.getEndDate() == null ){
            sessionDto.setEndDate(afterAddingOneMin);
        }
        Schedule schedule = scheduleRepository.findById(sessionDto.getIdSchedule()).orElse(null);
        if (schedule != null) {
            Session session = Session.builder().startDate(sessionDto.getStartDate())
                    .endDate(sessionDto.getEndDate())
                    .schedule(schedule).build();
            return sessionRepository.save(session);
        }
        return null;
    }
}

