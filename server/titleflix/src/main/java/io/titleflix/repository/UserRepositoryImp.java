package io.titleflix.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.titleflix.entity.User;

/**
 * This is a User Repository layer which queries the data and returns to the
 * Service layer
 * 
 * @author nandan
 *
 */
@Repository
public class UserRepositoryImp implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	// This functionality is us used to find the user details with its Email Id
	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pemail", email.trim());
		List<User> existingUser = query.getResultList();
		if (existingUser.isEmpty()) {
			return null;
		} else {
			return existingUser.get(0);
		}
	}

	// This functionality is used for a user logIn
	@Override
	public User signIn(User user) {
		TypedQuery<User> query = em.createNamedQuery("User.signIn", User.class);
		query.setParameter("pemail", user.getEmail().trim());
		query.setParameter("ppassword", user.getPassword());
		List<User> validUser = query.getResultList();
		if (validUser.isEmpty()) {
			return null;
		} else {
			return validUser.get(0);
		}

	}

	// This functionality is used for a User Registartion
	@Override
	public User signUp(User user) {
		em.persist(user);
		return user;
	}

	// This functionality is used for user signUp
	@Override
	public List<User> findAllUsers() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		List<User> usersList = query.getResultList();
		return usersList;
	}

	// This functionality is used to find the user by its UserID
	@Override
	public User findByUserId(String userId) {
		User existingUser = em.find(User.class, userId);
		return existingUser;
	}

}
