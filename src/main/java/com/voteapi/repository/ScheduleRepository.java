package com.voteapi.repository;

import com.voteapi.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    Optional <Schedule> findByName(String name);
}
