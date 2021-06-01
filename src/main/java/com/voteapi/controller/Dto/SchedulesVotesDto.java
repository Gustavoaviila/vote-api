package com.voteapi.controller.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchedulesVotesDto {

    private String nameSchedule;

    private  Integer quantityVote;

    private Boolean isTrue;


}
