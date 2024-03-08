package com.yma.jpasample;

import com.yma.jpasample.model.Author;
import com.yma.jpasample.model.Video;
import com.yma.jpasample.repositories.AuthorRepository;
import com.yma.jpasample.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaSampleApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository authorRepository,
			VideoRepository videoRepository){

		return  args -> {
			var author = Author.builder()
					.firstName("John")
					.lastName("Wick")
					.email("john@wicked.com")
					.build();

			authorRepository.save(author);


			var author2 = Author.builder()
					.firstName("John2")
					.lastName("Wick2")
					.email("john@wicked2.com")
					.build();

			authorRepository.save(author2);

			//Inheritance in database
			var video = new Video();
			video.setLength(10);
			video.setName("Sample Video");

			videoRepository.save(video);
		};
    }

}
