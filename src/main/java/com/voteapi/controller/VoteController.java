package com.voteapi.controller;

import com.voteapi.controller.Dto.SchedulesVotesDto;
import com.voteapi.controller.Dto.StatusCpfDto;
import com.voteapi.controller.Dto.VoteDto;
import com.voteapi.controller.Dto.VoteReturnDto;
import com.voteapi.repository.VoteRepository;
import com.voteapi.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private VoteService voteService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VoteReturnDto createVote (@RequestBody @Valid VoteDto voteDto){
        return voteService.createVote(voteDto);
    }

    @GetMapping
    public List<SchedulesVotesDto> schedulesVotesDtos (){
        return voteService.listVotes();
    }

    @GetMapping ("{cpf}")
    public StatusCpfDto verifyCpf (@PathVariable String cpf){
        return voteService.verifyCpf (cpf);
    }

}

