package com.songvoting.vote.repository;

import com.songvoting.vote.domain.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findAllByOrderByVotesDesc();

    @Modifying
    @Query("UPDATE Song t set t.votes = t.votes + 1 WHERE t.id = ?1")
    void incrementVotes(Long id);
}