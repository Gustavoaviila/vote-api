package com.voteapi.controller.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoteDto {

    private String cpf;

    private Boolean vote;

    private Integer idSession;

    private Integer idSchedule;
}
