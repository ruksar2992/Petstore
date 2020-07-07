package com.example.petstore.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.petstore.dao.OrderDao;
import com.example.petstore.dao.UserDao;
import com.example.petstore.dto.OrderResponseDto;
import com.example.petstore.exception.InvalidCredentialsException;
import com.example.petstore.model.OrderPets;
import com.example.petstore.model.User;
import com.example.petstore.service.OrderService;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OrderServiceImpl   implements OrderService{
    @Autowired
    UserDao userDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    PetServiceImpl petServiceImpl;
    


    @Override
    public OrderResponseDto orderPetsByPetId(int userId, int petId) throws InvalidCredentialsException {
        
        OrderPets orderPets = new OrderPets();
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        Optional<User> user = userDao.findAllByUserId(userId);
         if (!user.isPresent()) {
             throw new InvalidCredentialsException("UserId is not valid,Enter correct one");
            
         }
         orderPets.setUserId(userId);
         orderPets.setPetId(petId);
         orderPets.setOrderDate(LocalDate.now());
         orderDao.save(orderPets);
         petServiceImpl.updatePetStatus(petId);
         orderResponseDto.setMessage("PetOrderSuccessfully");
         orderResponseDto.setStatusCode(HttpStatus.OK.value());
         return  orderResponseDto;
         
    }


}
 


















