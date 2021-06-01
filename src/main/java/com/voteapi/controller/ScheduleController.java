package com.voteapi.controller;


import com.voteapi.entity.Schedule;
import com.voteapi.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSchedule (@RequestBody Schedule schedule){
        service.createSchedule(schedule);
    }

    @GetMapping ("{id_schedule}")
    public Schedule getScheduleById(@PathVariable("id_schedule") Integer idSchedule){
       return service.getScheduleById(idSchedule);
    }

    @GetMapping ("/names/{name}")
    public Schedule getScheduleByName(@PathVariable("name") String nameSchedule){
        return service.getScheduleByName(nameSchedule);
    }
}

