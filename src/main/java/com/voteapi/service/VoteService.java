package com.voteapi.service;

import com.voteapi.client.UsersClient;
import com.voteapi.controller.Dto.SchedulesVotesDto;
import com.voteapi.controller.Dto.StatusCpfDto;
import com.voteapi.controller.Dto.VoteDto;
import com.voteapi.controller.Dto.VoteReturnDto;
import com.voteapi.entity.Schedule;
import com.voteapi.entity.Session;
import com.voteapi.entity.Vote;
import com.voteapi.repository.ScheduleRepository;
import com.voteapi.repository.SessionRepository;
import com.voteapi.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoteService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private UsersClient usersClient;




    public VoteReturnDto createVote(VoteDto voteDto) {
        Session session = sessionRepository.findById(voteDto.getIdSession()).orElse(null);
        Schedule schedule = scheduleRepository.findById(voteDto.getIdSchedule()).orElse(null);
        Date date = new Date();
        if (date.after(session.getStartDate()) && date.before(session.getEndDate())) {
            if (session != null && schedule != null) {
                Vote vote = Vote.builder().session(session)
                        .schedule(schedule)
                        .cpf(voteDto.getCpf())
                        .vote(voteDto.getVote())
                        .build();
                voteRepository.save(vote);
                return VoteReturnDto.builder()
                        .cpf(voteDto.getCpf())
                        .vote(voteDto.getVote())
                        .startDate(session.getStartDate())
                        .endDate(session.getEndDate())
                        .build();
            }
        }
            return null;
    }
    public List<SchedulesVotesDto> listVotes(){
        List<Schedule> listSchedules = scheduleRepository.findAll();
        List<SchedulesVotesDto> response = Collections.emptyList();
        response =listSchedules.stream().map(schedule -> {
           List<Vote> votesSchedules =  voteRepository.findByNameFetchVotes(schedule.getId());
            return SchedulesVotesDto.builder().quantityVote(votesSchedules.size())
                    .nameSchedule(schedule.getName())
                    .build();
        }).collect(Collectors.toList());
        return response;
    }

    public StatusCpfDto verifyCpf(String cpf) {
        return usersClient.verifyCpf(cpf).getBody();
    }
}
