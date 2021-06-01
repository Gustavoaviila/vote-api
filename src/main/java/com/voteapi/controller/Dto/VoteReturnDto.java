package com.voteapi.controller.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteReturnDto {

    private String cpf;

    private Boolean vote;

    private Date startDate;

    private Date endDate;

}
