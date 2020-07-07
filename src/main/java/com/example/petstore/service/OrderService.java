package com.example.petstore.service;

import com.example.petstore.dto.OrderResponseDto;
import com.example.petstore.dto.OrdersDetailsListResponseDto;
import com.example.petstore.exception.InvalidCredentialsException;

public interface OrderService {

	OrderResponseDto orderPetsByPetId(int userId, int petId) throws InvalidCredentialsException;

	Object OrderPetsByPetId(int i, int j);

	OrdersDetailsListResponseDto getOrdersListByUserId(int userId) throws InvalidCredentialsException;

}
