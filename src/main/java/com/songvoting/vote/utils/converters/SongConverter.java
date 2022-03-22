package com.songvoting.vote.utils.converters;

import com.songvoting.vote.domain.dtos.SongDto;
import com.songvoting.vote.domain.entities.Song;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class SongConverter {
    public static SongDto convert(Song song) {
        if (song == null) {
            return null;
        }
        return SongDto.builder()
                .id(song.getId())
                .songName(song.getSongName())
                .votes(song.getVotes())
                .build();
    }

    public static Song convert(SongDto songDto) {
        if (songDto == null) {
            return null;
        }
        return Song.builder()
                .id(songDto.getId())
                .songName(songDto.getSongName())
                .votes(songDto.getVotes())
                .build();
    }

    public static List<SongDto> convertEntitiesToDtos(List<Song> songs) {
        List<SongDto> dtos = new ArrayList<>();
        if (songs != null) {
            return songs.stream().map(SongConverter::convert).collect(Collectors.toList());
        }
        return dtos;
    }
}
