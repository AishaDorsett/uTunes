package com.JavaIdea4.UTunes.controller;

import com.JavaIdea4.UTunes.model.Tune;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TuneController {

	@GetMapping("/search")
	public String index() {
		// String search = "Search";
		return "homepage/search.html";
		// return search;
	}

	@PostMapping("/search")
	public RedirectView create(@ModelAttribute Tune tune) {
		return new RedirectView("/search");
	}
}