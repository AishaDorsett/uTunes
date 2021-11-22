package com.JavaIdea4.UTunes.controller;

import com.JavaIdea4.UTunes.model.Tune;
import com.JavaIdea4.UTunes.repository.TuneRepository;
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

	@GetMapping("/add/favourites")
	public String addFavourites() {
		return "homepage/favourites.html";
	}


	// @PostMapping("/search")
	// public RedirectView create(@ModelAttribute Tune tune) {
	//   repository.save(tune);
	// 	return new RedirectView("/search");
	// }

	
}