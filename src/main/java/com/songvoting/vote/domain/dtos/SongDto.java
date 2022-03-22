package com.songvoting.vote.domain.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {
    private Long id;
    private String songName;
    private Integer votes;
}
