package com.example.petstore.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.petstore.model.User;




@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	/**
	 * This method is used to authenticate User
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public User findByUserNameAndPassword(String userName, String password);

	public Optional<User> findAllByUserId(int userId);
}
