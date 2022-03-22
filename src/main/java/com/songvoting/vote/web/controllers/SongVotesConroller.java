package com.songvoting.vote.web.controllers;

import com.songvoting.vote.domain.dtos.SongDto;
import com.songvoting.vote.service.SongVotesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("votes")
public class SongVotesConroller {
    @Autowired
    SongVotesService songVotesService;

    @GetMapping
    public String template(Model model) {
        model.addAttribute("songs", songVotesService.getAllSongs());
        return "index";
    }

    @GetMapping("/{id}")
    public SongDto getSong(@PathVariable Long id) {
        return songVotesService.getSong(id);
    }

    @GetMapping("/thanks")
    public String thanksTemplate(Model model) {
        model.addAttribute("message", "תודה שבחרתם, בואו לחגוג איתנו!");
        return "thanks";
    }

    @GetMapping("/results")
    public String resultTemplate(Model model) {
        model.addAttribute("songs", songVotesService.getAllSongsOrderedByVotes());
        return "results";
    }

    @PostMapping("/{id}")
    public ModelAndView vote(@PathVariable Long id, ModelMap modelMap) {
        songVotesService.vote(id);
        return new ModelAndView("redirect:/votes/thanks", modelMap);
    }
}
