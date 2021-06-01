package com.voteapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "tb_pauta")
@Builder
public class Schedule {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column (name = "name")
    private String name;






}
