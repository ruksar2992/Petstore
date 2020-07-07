package com.example.petstore.service;

import com.example.petstore.dto.OrderResponseDto;
import com.example.petstore.exception.InvalidCredentialsException;

public interface OrderService {

	OrderResponseDto orderPetsByPetId(int userId, int petId) throws InvalidCredentialsException;

}