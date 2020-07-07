package com.example.petstore.controllertest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.petstore.controller.PetController;
import com.example.petstore.dto.PetDetailsResponseDto;
import com.example.petstore.dto.PetListResponseDto;
import com.example.petstore.exception.InvalidCredentialsException;
import com.example.petstore.service.PetService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PetControllerTest {
	@InjectMocks
    PetController petController;


    @Mock
    PetService petService;


    @Test
    public void findHotelDetails() throws InvalidCredentialsException {


        PetDetailsResponseDto pet = new PetDetailsResponseDto();
        pet.setPetId(1);
        pet.setDescription("barks");
        pet.setPrice(50000);





        Mockito.when(petService.getPetsByPetName("petName")).thenReturn(null);


        ResponseEntity<PetListResponseDto> responsebusdetailsdto = petController.searchPets("petName");
        assertEquals(HttpStatus.OK, responsebusdetailsdto.getStatusCode());


    }








}
