package com.songvoting.vote.service;

import com.songvoting.vote.domain.dtos.SongDto;
import com.songvoting.vote.domain.entities.Song;
import com.songvoting.vote.repository.SongRepository;
import com.songvoting.vote.utils.converters.SongConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class SongVotesService {
    @Autowired
    private SongRepository songRepository;

    public List<SongDto> getAllSongs() {
        return SongConverter.convertEntitiesToDtos(songRepository.findAll());
    }

    public List<SongDto> getAllSongsOrderedByVotes() {return SongConverter.convertEntitiesToDtos(songRepository.findAllByOrderByVotesDesc());}

    public SongDto getSong(Long id) {
        return SongConverter.convert(songRepository.getById(id));
    }

    @Transactional
    public void vote(Long id) {
        songRepository.incrementVotes(id);
    }

    public void createSong(String songName) {
        songRepository.save(Song.builder().songName(songName).build());
    }
}
