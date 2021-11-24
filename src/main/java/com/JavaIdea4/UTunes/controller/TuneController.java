package com.JavaIdea4.UTunes.controller;

import java.security.Principal;
import java.util.Set;

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

@Controller
public class TuneController {

	@Autowired
	TuneRepository repository;
	@Autowired
	UserRepository userRepository;

	@GetMapping("/tunes")
	public String listtunes(Model model) { // why do we need Model? It works without...
		return "homepage/search.html";
	}
	
	@GetMapping("/tunes/search")
	public String search(@RequestParam String genre, Model model) {
		Iterable<Tune> tunes = repository.findByGenre(genre);
		model.addAttribute("tunes",tunes);
		return "homepage/search.html";
		// return search;
	}

	@GetMapping("/tunes/favourites")
	public String favourites() {
    	return "homepage/favourites.html";
	}

	// @GetMapping("/add/favourites")
	// public String addFavourites() {
	// 	return "homepage/favourites.html";
	// }
		@GetMapping("/add/{id}")
		public String addTune(@RequestParam Long id, Model model, Principal principal) {
			User user = userRepository.findByUsername(principal.getName()).get(0);
			Tune tune = repository.findById(id).get();
			user.tunes.add(tune);
			userRepository.save(user);
			model.addAttribute("userId", userRepository.findAll());
			model.addAttribute("tuneId", repository.findAll());
			Set<Tune> tunes = user.tunes;
			model.addAttribute("tunes", tunes);
			return "homepage/favourites.html";
		}
}