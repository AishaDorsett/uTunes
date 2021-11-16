package com.JavaIdea4.UTunes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TuneController {

	@GetMapping("/search")
	public String index() {
		return "/search.html";
	}

}