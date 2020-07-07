package com.example.petstore.controllertest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.petstore.controller.OrderController;
import com.example.petstore.dto.OrderRequestDto;
import com.example.petstore.dto.OrderResponseDto;
import com.example.petstore.exception.InvalidCredentialsException;
import com.example.petstore.service.OrderService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {
	@InjectMocks
    OrderController orderController;


    @Mock
    OrderService orderService;
    
    @Test
    public void bookingDetails() throws InvalidCredentialsException {
        OrderRequestDto booking = new OrderRequestDto();
        booking.setUserId(1);
        booking.setPetId(1);
        
        OrderResponseDto book = new OrderResponseDto();


        Mockito.when(orderService.orderPetsByPetId(1, 1)).thenReturn(book);


        ResponseEntity<OrderResponseDto> responsebusdetailsdto = orderController.orderPets(1, booking);
        assertEquals(HttpStatus.OK, responsebusdetailsdto.getStatusCode());


    }
    
    


}









