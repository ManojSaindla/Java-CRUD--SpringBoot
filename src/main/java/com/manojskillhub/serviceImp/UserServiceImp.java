package com.manojskillhub.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manojskillhub.entity.User;
import com.manojskillhub.payload.UserDto;
import com.manojskillhub.repository.UserRepository;
import com.manojskillhub.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user =userDtoToEntity(userDto); //coverted userdto to user
		User savedUser=userRepository.save(user);
		return entityToUserDto(savedUser);
	}
 
	private User userDtoToEntity(UserDto userDto) {
		User user =new User();
	
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		
		return user;
	}
	private UserDto entityToUserDto(User savedUser) {
		UserDto userdto =  new UserDto();
		userdto.setId(savedUser.getId());
		userdto.setName(savedUser.getName());
		userdto.setEmail(savedUser.getEmail());
		userdto.setPassword(savedUser.getPassword());
		
		return userdto;
		
	}
}
