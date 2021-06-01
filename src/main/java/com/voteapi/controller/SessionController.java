package com.voteapi.controller;

import com.voteapi.controller.Dto.SessionDto;
import com.voteapi.entity.Session;
import com.voteapi.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/sessions")
public class SessionController {

    @Autowired
    private SessionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session createSession (@RequestBody SessionDto sessionDto){
        return service.createSession (sessionDto);
    }

}
