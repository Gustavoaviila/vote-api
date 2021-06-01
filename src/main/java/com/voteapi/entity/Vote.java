package com.voteapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_vote")
@Builder
public class Vote {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "cpf")
    @NotBlank(message = "The cpf field cannot be empty")
    private String cpf;

    @Column(name = "vote")
    @NotBlank (message = "The vote field cannot be empty")
    private Boolean vote;

    @JoinColumn (name = "id_session" )
    @ManyToOne
    @NotBlank (message = "The session field cannot be empty")
    private Session session;

    @JoinColumn (name = "id_schedule")
    @ManyToOne
    private Schedule schedule;
}
