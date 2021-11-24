package com.JavaIdea4.UTunes.controller;

import java.security.Principal;
import java.util.Set;
import java.io.IOException;

import com.JavaIdea4.UTunes.model.Tune;
import com.JavaIdea4.UTunes.model.User;
import com.JavaIdea4.UTunes.repository.TuneRepository;
import com.JavaIdea4.UTunes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TuneController {

	@Autowired
	TuneRepository repository;
	@Autowired
	UserRepository userRepository;

	@GetMapping("/tunes")
	public String listtunes(Model model) { 
		return "homepage/search.html";
	}
	
	@GetMapping("/tunes/search")
	public String search(@RequestParam String genre, Model model) {
		Iterable<Tune> tunes = repository.findByGenre(genre);
		model.addAttribute("tunes",tunes);
		return "homepage/search.html";
	}

	@GetMapping("/tunes/favourites")
	public String favourites(Model model, Principal principal) {
		User user = userRepository.findByUsername(principal.getName()).get(0);
		model.addAttribute("userId", userRepository.findAll());
			model.addAttribute("tuneId", repository.findAll());
			Set<Tune> tunes = user.tunes;
			model.addAttribute("tunes", tunes);
    	return "homepage/favourites.html";
	}

		@GetMapping("/add/{id}")
		public RedirectView addTune(@RequestParam Long id, Model model, Principal principal) {
			User user = userRepository.findByUsername(principal.getName()).get(0);
			Tune tune = repository.findById(id).get();
			user.tunes.add(tune);
			userRepository.save(user);
			model.addAttribute("userId", userRepository.findAll());
			model.addAttribute("tuneId", repository.findAll());
			Set<Tune> tunes = user.tunes;
			model.addAttribute("tunes", tunes);
			return new RedirectView("/tunes/favourites");
		}

		@GetMapping("/add/tunes")
    public String addSongs(Model model) {
        model.addAttribute("tune", new Tune());
        return "homepage/addSong.html";
    }
		@PostMapping("/add/tunes")
    public RedirectView signup(@ModelAttribute Tune tune, Model model) {
			model.addAttribute("tune", new Tune());
      repository.save(tune);

        // return new RedirectView("homepage/search.html");
				return new RedirectView("/tunes");
    }
}