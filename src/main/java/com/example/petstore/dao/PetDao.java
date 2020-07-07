package com.example.petstore.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.petstore.model.Pet;
@Repository
public interface PetDao extends CrudRepository<Pet, Integer> {
	@Query("SELECT e FROM Pet e WHERE e.petName LIKE %?1%")
    Optional<List<Pet>> findAllByPetName(String petName);
    
}
