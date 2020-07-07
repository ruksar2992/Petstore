package com.example.petstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.petstore.dto.OrderRequestDto;
import com.example.petstore.dto.OrderResponseDto;
import com.example.petstore.exception.InvalidCredentialsException;
import com.example.petstore.service.OrderService;
@RestController
public class OrderController {
	@Autowired
    OrderService orderService;
	
    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<OrderResponseDto> orderPets(@PathVariable("userId")int userId,OrderRequestDto orderRequestDto) throws InvalidCredentialsException {


        OrderResponseDto orderResponseDto = orderService.orderPetsByPetId(userId,orderRequestDto.getPetId());


        return new ResponseEntity<OrderResponseDto>(orderResponseDto, HttpStatus.OK);


    }


}
 
