package com.example.petstore.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.petstore.model.OrderPets;

@Repository

public interface OrderDao extends CrudRepository<OrderPets ,Integer> {

	Optional<List<OrderPets>> findAllByUserId(int userId);


}


