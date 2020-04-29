package com.example.myspringproject;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoolHeroController {

	private HeroRepository heroRepository;

	public CoolHeroController(HeroRepository heroRepository) {
		this.heroRepository = heroRepository;
	}

	@GetMapping("/coolHeroes")
	@CrossOrigin(origins="http://localhost:4200")
	public Collection<Hero> getCoolHero() {
		System.out.println("Ok! Here are the cool heroes");
		return heroRepository.findAll().stream().filter(s -> s.getName().contains(" ")).collect(Collectors.toList());
	}

}
