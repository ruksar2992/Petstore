package com.example.petstore.service;

import java.util.List;

import com.example.petstore.dto.PetListResponseDto;
import com.example.petstore.exception.InvalidCredentialsException;

public interface PetService {

	public PetListResponseDto getPetsByPetName(String petName) throws InvalidCredentialsException;
}
