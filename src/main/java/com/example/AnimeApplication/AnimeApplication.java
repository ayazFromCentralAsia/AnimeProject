package com.example.AnimeApplication;

import net.sandrohc.jikan.Jikan;
import net.sandrohc.jikan.model.anime.Anime;
import net.sandrohc.jikan.query.random.RandomAnimeQuery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class AnimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimeApplication.class, args);
	}

}
