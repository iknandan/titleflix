package io.titleflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.titleflix.entity.CommentRating;
import io.titleflix.entity.Title;
import io.titleflix.exception.TitleNotFound;
import io.titleflix.exception.UserNotFound;

/**
 * This is a Comments and Rating repository which retrives the data from
 * database and returns to the service layer
 * 
 * @author nandan
 *
 */
@Repository
public class CommentRateRepositoryImp implements CommentRateRepository {

	@PersistenceContext
	private EntityManager em;

	// This functionality is to persist the review and also to update the
	// Average Rating of a title.
	@Override
	public CommentRating reviewTitle(CommentRating review) throws UserNotFound, TitleNotFound {
		// To persist the review object
		em.persist(review);
		// Functionality to update the Average Rating of a Title
		Double averageValue = averagerating(review.getMovieId().getMovieId());
		Title existingTitle = review.getMovieId();
		existingTitle.setAverageRating(averageValue);
		// Update the title with new averageRating value
		em.merge(existingTitle);
		return review;
	}

	// Functionality to calculate the averageRating of a title
	private Double averagerating(String movieId) {
		// TODO Auto-generated method stub
		TypedQuery<Double> averageQuery =(TypedQuery<Double>) em.createNamedQuery("Rating.averageQuery");
		averageQuery.setParameter("pmovieId", movieId);
		Double averageRating = averageQuery.getSingleResult();
		return averageRating;
	}

	// To find all reviews present in the database - demo purpose only
	@Override
	public List<CommentRating> viewAllReviwes() {
		TypedQuery<CommentRating> reiewListQuery = em.createNamedQuery("Comment.findAll", CommentRating.class);
		List<CommentRating> reiewList = reiewListQuery.getResultList();
		return reiewList;
	}

	// To find all the reviews of a particular Title
	@Override
	public List<CommentRating> viewReviewsTitle(String movieId) {
		TypedQuery<CommentRating> reviewQuery = em.createNamedQuery("Reviews.ofTitle", CommentRating.class);
		reviewQuery.setParameter("pmovieId", movieId);
		List<CommentRating> reviewList = reviewQuery.getResultList();
		return reviewList;
	}

	// To delete the particular Title reviews
	@Override
	public void deleteReviewTitle(List<CommentRating> checkRating) {
		// TODO Auto-generated method stub

		for (CommentRating commentRating : checkRating) {
			em.remove(commentRating);
		}

	}

}
