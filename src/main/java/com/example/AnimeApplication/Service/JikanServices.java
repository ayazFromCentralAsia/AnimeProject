package com.example.AnimeApplication.Service;


import com.example.AnimeApplication.Entity.SaverObject;
import net.sandrohc.jikan.Jikan;
import net.sandrohc.jikan.exception.JikanQueryException;
import net.sandrohc.jikan.model.anime.Anime;
import net.sandrohc.jikan.query.random.RandomAnimeQuery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JikanServices {
    private final Jikan jikan = new Jikan();

    public ArrayList<SaverObject> getTopAnime(){
        try {
            ArrayList<Anime> animeList =  (ArrayList<Anime>) jikan.query().anime().top().limit(25).execute().collectList().block();
            ArrayList<SaverObject> objectArrayList = new ArrayList<>();
            for (Anime anime :animeList){
                SaverObject saverObject = new SaverObject();
                objectPlaceHolder(anime, saverObject);
                objectArrayList.add(saverObject);
            }
            return objectArrayList;
        } catch (JikanQueryException e) {
            throw new RuntimeException(e);
        }
    }
    public void randomAnime(){
    }
    public ArrayList<SaverObject> getAnimeByTitle(String string){
        try {
            ArrayList<Anime> animeArrayList = (ArrayList<Anime>) jikan.query().anime().search().query(string).limit(10).execute().collectList().block();
            ArrayList<SaverObject> objectArrayList = new ArrayList<>();
            for (Anime anime :animeArrayList){
                SaverObject saverObject = new SaverObject();
                objectPlaceHolder(anime, saverObject);
                objectArrayList.add(saverObject);
            }
            return objectArrayList;
        } catch (JikanQueryException e) {
            throw new RuntimeException(e);
        }
    }

    public void objectPlaceHolder(Anime anime, SaverObject saverObject){
        saverObject.setId(anime.malId);
        saverObject.setTitle(anime.title);
        saverObject.setType(String.valueOf(anime.type));
        saverObject.setPopularity(anime.popularity);
        saverObject.setRank(anime.rank);
        saverObject.setEpisodes(anime.episodes);
        saverObject.setGenreEntities(anime.genres);
        saverObject.setImageUrl(anime.getImages().getPreferredImageUrl());
        saverObject.setTrailer(anime.trailer.embedUrl);
    }

    public SaverObject getAnimeById(int id){
        try {
            Anime anime = jikan.query().anime().get(id).execute().block();
            SaverObject saverObject = new SaverObject();
            objectPlaceHolder(anime,saverObject);
            return saverObject;
        } catch (JikanQueryException e) {
            throw new RuntimeException(e);
        }
    }
    public SaverObject getRandomAnime() {
        try {
            Anime anime = jikan.query().random().anime().execute().block();
            SaverObject saverObject = new SaverObject();
            objectPlaceHolder(anime,saverObject);
            return saverObject;
        } catch (JikanQueryException e) {
            throw new RuntimeException(e);
        }
    }
}
