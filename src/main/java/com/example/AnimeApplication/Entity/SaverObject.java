package com.example.AnimeApplication.Entity;

import net.sandrohc.jikan.model.GenreEntity;
import net.sandrohc.jikan.model.common.Trailer;

import java.util.Collection;

public class SaverObject {

    public int id;
    public String title;
    public String type;

    public Integer episodes;

    public int rank;

    public int popularity;

    public String imageUrl;

    public String trailer;


    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Collection<GenreEntity> genreEntities;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public Collection<GenreEntity> getGenreEntities() {
        return genreEntities;
    }

    public void setGenreEntities(Collection<GenreEntity> genreEntities) {
        this.genreEntities = genreEntities;
    }
}
