package com.example.petstore.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.petstore.dao.OrderDao;
import com.example.petstore.dao.UserDao;
import com.example.petstore.dto.OrderResponseDto;
import com.example.petstore.dto.OrdersDetailsListResponseDto;
import com.example.petstore.dto.OrdersListResponseDto;
import com.example.petstore.exception.InvalidCredentialsException;
import com.example.petstore.model.OrderPets;
import com.example.petstore.model.Pet;
import com.example.petstore.model.User;
import com.example.petstore.service.OrderService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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



	@Override
	public Object OrderPetsByPetId(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
    public OrdersDetailsListResponseDto getOrdersListByUserId(int userId) throws InvalidCredentialsException {
       
        OrdersDetailsListResponseDto ordersDetailsListResponseDto = new OrdersDetailsListResponseDto();
            Optional<List<OrderPets>> petDetails=orderDao.findAllByUserId(userId);
            if (!petDetails.isPresent()) {
               
                throw new InvalidCredentialsException("NoT a valid user.check userId");
            }
         
             List<OrdersListResponseDto> orderPetList= petDetails.get().stream().map(orderPets -> getPetDetailsResponseDto(orderPets)).collect(Collectors.toList());
             ordersDetailsListResponseDto.setMessage("order history of pets");
             ordersDetailsListResponseDto.setStatusCode(HttpStatus.OK.value());
             ordersDetailsListResponseDto.setOrdersListResponseDto(orderPetList);
                return ordersDetailsListResponseDto;
               
          
            
        }
        private OrdersListResponseDto getPetDetailsResponseDto(OrderPets orderPets) {
           
            OrdersListResponseDto ordersListResponseDto=new OrdersListResponseDto();
            Pet petDetail=Pet.findAllByPetId(orderPets.getPetId());
            ordersListResponseDto.setPetName(petDetail.getPetName());
            ordersListResponseDto.setPrice(petDetail.getPrice());
            ordersListResponseDto.setDescription(petDetail.getDescription());
           
            BeanUtils.copyProperties(orderPets, ordersListResponseDto);
            return ordersListResponseDto;
        }
    }
 

 


 
 



	


 


















