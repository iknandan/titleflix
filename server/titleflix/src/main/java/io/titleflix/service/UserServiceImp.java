package io.titleflix.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.titleflix.entity.User;
import io.titleflix.exception.IncorrectCredentials;
import io.titleflix.exception.UserAlreadyExists;
import io.titleflix.exception.UserNotFound;
import io.titleflix.repository.UserRepository;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	

	@Override
	public User signIn(User user) throws UserNotFound, IncorrectCredentials {
		// TODO Auto-generated method stub
		User existing = userRepository.findByEmail(user.getEmail());
		if(existing != null){
			User validUser =  userRepository.signIn(user);
			if(validUser != null){
				return validUser;
			}
			else{
				throw new IncorrectCredentials();
			}
		}
		else{
			throw new UserNotFound();	
		}
		
	}



	@Override
	public User signUp(User user) throws UserAlreadyExists {
		// TODO Auto-generated method stub
		User existing = userRepository.findByEmail(user.getEmail());
		if(existing == null){
		User registeredUser = userRepository.signUp(user);	
		return registeredUser;
		}
		else{
			throw new UserAlreadyExists();
		}
		
	}



	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		List<User> findAllUsers = userRepository.findAllUsers();
		
		return findAllUsers;
	}

}
