package com.example.myspringproject;

import java.util.Collections;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class Angularspringproject1Application {

	public static void main(String[] args) {
		SpringApplication.run(Angularspringproject1Application.class, args);
	}

	@Bean
	ApplicationRunner init(HeroRepository heroRepository) {
		return args -> {
			Stream.of("Thor", "Hulk", "Ironman", "black penther", "wonder woman", "dr strange").map(Hero::new)
					.forEach(heroRepository::save);
			heroRepository.findAll().forEach(System.out::println);
		};
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
		UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		configuration.setAllowedMethods(Collections.singletonList("*"));
		configuration.setAllowedHeaders(Collections.singletonList("*"));
		configurationSource.registerCorsConfiguration("/**", configuration);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(
				new CorsFilter(configurationSource));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}
