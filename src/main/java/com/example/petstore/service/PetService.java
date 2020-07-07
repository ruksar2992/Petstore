package com.example.petstore.service;

import java.util.List;

import com.example.petstore.dto.PetDetailsResponseDto;

public interface PetService {
    public List<PetDetailsResponseDto> getPetDetailsByPetName(String petName);
}
