package com.JavaIdea4.UTunes.controller;

import java.security.Principal;

import com.JavaIdea4.UTunes.model.Favourite;
import com.JavaIdea4.UTunes.model.Tune;
import com.JavaIdea4.UTunes.model.User;
import com.JavaIdea4.UTunes.repository.FavouriteRepository;
import com.JavaIdea4.UTunes.repository.TuneRepository;
import com.JavaIdea4.UTunes.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
public class TuneController {

	@Autowired
	TuneRepository repository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	FavouriteRepository favouriteRepository;

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

	@GetMapping("/tune/{id}")
	public RedirectView save(@PathVariable Long id, @ModelAttribute Tune tune) {
		repository.save(tune);
		return new RedirectView("tune/{id}");
	}

	@GetMapping("/add/{id}")
	public String addTune(@PathVariable Long id, Model model) {
		Tune tune = repository.findById(id).get();
		model.addAttribute("tune", tune);
		return "homepage/favourites.html";
	}

	@PostMapping("/add")
	// public RedirectView tune(@ModelAttribute Tune tune) {
	// 	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	// 	String username = ((UserDetails) principal).getUsername();
	// 	User thisUser = userRepository.findByUsername(username).get(0);

	// 	return new RedirectView("/favourites");
	public RedirectView fave(@PathVariable("id") Long id, Principal principal) {
		User thisUsers = userRepository.findByUsername(principal.getName()).get(0);
		Tune thisTune = repository.findById(id).get();
		Favourite fave = new Favourite(thisUsers.getId());
		fave.setTune(thisTune);
		favouriteRepository.save(fave);
		return new RedirectView("/favourites");
	}


	// @PostMapping("/search")
	// public RedirectView create(@ModelAttribute Tune tune) {
	//   repository.save(tune);
	// 	return new RedirectView("/search");
	// }

	
}