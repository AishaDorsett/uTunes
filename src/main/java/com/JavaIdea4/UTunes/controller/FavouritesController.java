package com.JavaIdea4.UTunes.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import com.JavaIdea4.UTunes.model.Favourite;
import com.JavaIdea4.UTunes.model.Tune;
import com.JavaIdea4.UTunes.model.User;
import com.JavaIdea4.UTunes.repository.FavouriteRepository;
import com.JavaIdea4.UTunes.repository.TuneRepository;
import com.JavaIdea4.UTunes.repository.UserRepository;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.security.core.userdetails.UserDetails;

public class FavouritesController {
    @Autowired
    FavouriteRepository FavouriteRepository;
  
    @Autowired
    UserRepository userRepository;
  
    @Autowired
    TuneRepository tuneRepository;
  
    @GetMapping("/favourite")
    public RedirectView index() {
      return new RedirectView("/tunes");
    }
  
    @PostMapping("/tunes/{id}/favourites")
    public RedirectView fave(@PathVariable("id") Long id, Principal principal) {
      User thisUsers = userRepository.findByUsername(principal.getName()).get(0);
      Tune thisTune = tuneRepository.findById(id).get();
      Favourite fave = new Favourite(thisUsers.getId(), id);
    //   fave.setTune(thisTune);
      FavouriteRepository.save(fave);
      return new RedirectView("/tunes");
    }
}
