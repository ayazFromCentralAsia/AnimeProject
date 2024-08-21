package com.example.AnimeApplication.RestController;


import com.example.AnimeApplication.Entity.SaverObject;
import com.example.AnimeApplication.Service.JikanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AnimeControllerByRest {
    @Autowired
    JikanServices jikanServices;

    @GetMapping("/")
    public String news(){
        return "Today i try to make anime list )";
    }

    @GetMapping("/top")
    public ArrayList<SaverObject> animeTop(){
        return jikanServices.getTopAnime();
    }
    @GetMapping("/anime")
    public SaverObject randomAnime(){
        return jikanServices.getRandomAnime();
    }
    @GetMapping("/anime/name")
    public ArrayList<SaverObject> getByName(@RequestParam(name = "name",required = false) String name){
        return jikanServices.getAnimeByTitle(name);
    }
}
