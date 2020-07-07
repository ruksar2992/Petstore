package com.example.petstore.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.petstore.dao.PetDao;
import com.example.petstore.dto.PetDetailsResponseDto;
import com.example.petstore.dto.PetListResponseDto;
import com.example.petstore.exception.InvalidCredentialsException;
import com.example.petstore.model.Pet;
import com.example.petstore.service.PetService;
@Service
public class PetServiceImpl implements PetService{
    
	@Autowired
    PetDao petDao;
   @Override
    public PetListResponseDto getPetsByPetName(String petName) throws InvalidCredentialsException {
       PetListResponseDto petListResponseDto = new PetListResponseDto();
        Optional<List<Pet>> petDetails=petDao.findAllByPetName(petName);
        if (!petDetails.isPresent()) {
            
            throw new InvalidCredentialsException("No dogs available matching your request");
        }
      
         List<PetDetailsResponseDto> petList= petDetails.get().stream().map(pet -> getPetDetailsResponseDto(pet)).collect(Collectors.toList());
         petListResponseDto.setMessage("plese find list of available dogs");
           petListResponseDto.setStatusCode(HttpStatus.OK.value());
          petListResponseDto.setPetDetailsResponseDto(petList);
            return petListResponseDto;
            
       
         
    }
    private PetDetailsResponseDto getPetDetailsResponseDto(Pet pet) {
        
        PetDetailsResponseDto petDetailsResponse=new PetDetailsResponseDto();
        BeanUtils.copyProperties(pet, petDetailsResponse);
        return petDetailsResponse;
    }





}
 





