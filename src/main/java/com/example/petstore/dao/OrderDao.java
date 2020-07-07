package com.example.petstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.petstore.model.OrderPets;

@Repository

public interface OrderDao extends CrudRepository<OrderPets ,Integer> {


}


