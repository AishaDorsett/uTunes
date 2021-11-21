package com.JavaIdea4.UTunes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HelloController {

	@GetMapping("/")
	public RedirectView index() {
		// return "homepage/index.html";
		return new RedirectView("/tunes");
	}
}