package com.voteapi.repository;

import com.voteapi.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query(value = " select * from tb_vote where id_schedule= :id_schedule", nativeQuery = true)
    List<Vote> findByNameFetchVotes(@Param("id_schedule") Integer id);

}
