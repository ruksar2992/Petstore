package com.example.petstore.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petstore.dao.PetDao;
import com.example.petstore.dto.PetDetailsResponseDto;
import com.example.petstore.model.Pet;
import com.example.petstore.service.PetService;
@Service
public class PetServiceImpl implements PetService{
    
	@Autowired
	    PetDao petDao;

		@Override
	    public List<PetDetailsResponseDto> getPetDetailsByPetName(String petName) {
	        Optional<List<Pet>> petDetails=petDao.findAllByPetName(petName);
	        List<PetDetailsResponseDto> petDetailsResponseDto=new ArrayList<>();
	        if(petDetails.isPresent()) {
	            
	            return petDetails.get().stream().map(pet -> getPetDetailsResponseDto(pet)).collect(Collectors.toList());
	            
	        }
	        else {
	            return petDetailsResponseDto;
	        }
	         
	    }
	    private PetDetailsResponseDto getPetDetailsResponseDto(Pet pet) {
	        
	        PetDetailsResponseDto petDetailsResponse=new PetDetailsResponseDto();
	        BeanUtils.copyProperties(pet, petDetailsResponse);
	        return petDetailsResponse;
	    }

}






