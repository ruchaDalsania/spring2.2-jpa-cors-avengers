package com.example.myspringproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Hero {

	@Id
	@GeneratedValue
	private Long id;

	private @NotNull String name;

	Hero(String name) {
		this.name = name;
	}

}
