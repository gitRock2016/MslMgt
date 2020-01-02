package com.iwatakhr.mslmgt.presentation.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@EnableAutoConfiguration
@RequestMapping("/MslMgt")
public class App {

	@RequestMapping("/hello")
	public String hello(@RequestParam(value = "name", required = false, defaultValue = "MslMgt") String name,
			Model model) {
		model.addAttribute("name", name);
		return "helloworld";
	}

}