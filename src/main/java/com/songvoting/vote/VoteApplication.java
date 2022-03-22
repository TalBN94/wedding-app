package com.songvoting.vote;

import com.songvoting.vote.domain.entities.Song;
import com.songvoting.vote.repository.SongRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class VoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoteApplication.class, args);
	}

	@Bean
	ApplicationRunner init(SongRepository repository) {
		String[] data = {"ימים יפים - מועדון הקצב של אביהו פנחסוב",
				"שיר מספר 2", "שיר מספר 3"};
		return args -> {
			Stream.of(data).forEach(name -> {
				repository.save(Song.builder().songName(name).votes(0).build());
			});
		};
	}

}
