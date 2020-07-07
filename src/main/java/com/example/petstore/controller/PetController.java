package com.example.petstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.petstore.dto.PetDetailsResponseDto;
import com.example.petstore.service.PetService;

@RestController
public class PetController {

	@Autowired
	PetService petService;

	@GetMapping("/pet")
	public ResponseEntity<List<PetDetailsResponseDto>> searchpetDetails(
			@RequestParam(required = false) String petName) {

		System.out.println("hello");

		List<PetDetailsResponseDto> bookDetailsResponseDto = petService.getPetDetailsByPetName(petName);
		System.out.println(bookDetailsResponseDto);
		return new ResponseEntity<List<PetDetailsResponseDto>>(bookDetailsResponseDto, HttpStatus.OK);

	}

}
