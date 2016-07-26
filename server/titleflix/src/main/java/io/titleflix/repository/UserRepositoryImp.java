package io.titleflix.repository;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.titleflix.entity.User;

@Repository
public class UserRepositoryImp implements UserRepository {

	@PersistenceContext
	private EntityManager em;


	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createQuery("select u from User u where u.email =:pemail",User.class);
		query.setParameter("pemail", email.trim());
		List<User> existingUser = query.getResultList();
		if(existingUser.isEmpty()){
			return null;
		}
		else{
			return existingUser.get(0);
		}
		
		
		
	}

	@Override
	public User signIn(User user) {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createQuery("select u from User u where u.email = :pemail and u.password = :ppassword",User.class);
		query.setParameter("pemail", user.getEmail().trim());
		query.setParameter("ppassword", user.getPassword());
		List<User> validUser = query.getResultList();
		if(validUser.isEmpty()){
			return null;
		}
		else{
			return validUser.get(0);
		}
		
	}

	@Override
	public User signUp(User user) {
		// TODO Auto-generated method stub
		em.persist(user);
		return user;
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createQuery("select u from User u",User.class);
		List<User> usersList = query.getResultList();
		return usersList;
	}

}
