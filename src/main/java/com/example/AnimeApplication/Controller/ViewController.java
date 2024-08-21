package com.example.AnimeApplication.Controller;

import com.example.AnimeApplication.Entity.SaverObject;
import com.example.AnimeApplication.Service.JikanServices;
import jakarta.annotation.PreDestroy;
import net.sandrohc.jikan.model.anime.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Controller
public class ViewController {

    @Autowired
    JikanServices jikanServices;

    @GetMapping("/page")
    public String showPage(Model model){
        model.addAttribute("topAnime" ,jikanServices.getTopAnime());
        return "index";
    }

    @PostMapping("/search")
    public String showBySearch(Model model,
                               @RequestParam("title") String title){
        ArrayList<SaverObject> saverObjects =  jikanServices.getAnimeByTitle(title);
        model.addAttribute("searchResult", saverObjects);
        return "nextPage";
    }

    @GetMapping("/anime/details/{id}")
    public String getAnimeDetails(@PathVariable("id") int id, Model model) {
        SaverObject anime = jikanServices.getAnimeById(id);
        model.addAttribute("SaverObject", anime);
        return "animeWithDetails.html";
    }
}
