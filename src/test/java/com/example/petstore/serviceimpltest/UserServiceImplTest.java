package com.example.petstore.serviceimpltest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.petstore.dao.UserDao;
import com.example.petstore.dto.UserDto;
import com.example.petstore.exception.InvalidCredentialsException;
import com.example.petstore.model.User;
import com.example.petstore.serviceimpl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	User user;

	@Mock
	UserDao userDao;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	UserDto userDto;

	@BeforeEach
	public void setUp() {

		userDto = new UserDto();
		userDto.setUserName("ruksar");
		userDto.setPassword("ruksar");
		userDto.setMobileNumber("9887654321");
		userDto.setEmailId("ruk@gmail.com");

	}

	@Test
	public void saveUser() {
		// given
		when(userDao.save(any(User.class))).thenReturn(any(User.class));

		// when
		userServiceImpl.addUser(userDto);

		// then
		verify(userDao).save(any(User.class));

	}

	@Test
	public void authenticateTest1() throws InvalidCredentialsException {
		// given
		User user = new User();
		user.setUserName("ruksar");
		user.setPassword("ruksar");

		when(userDao.findByUserNameAndPassword("ruksar", "ruksar")).thenReturn(user);

		// when
		Boolean isExists = userServiceImpl.authenticateUser("ruksar", "ruksar");

		// then
		verify(userDao).findByUserNameAndPassword("ruksar", "ruksar");
		assertTrue(isExists);
	}

	@Test
	public void authenticateTest2() {
		// given
		User user = new User();
		user.setUserName("ruksar");
		user.setPassword("ruksar");

		when(userDao.findByUserNameAndPassword("ruksar", "ruksar")).thenReturn(null);

		// when

		// then
		assertThrows(InvalidCredentialsException.class, () -> userServiceImpl.authenticateUser("ruksar", "ruksar"));
	}

}
