package io.titleflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.titleflix.entity.CommentRating;
import io.titleflix.entity.Title;
import io.titleflix.entity.User;
import io.titleflix.exception.TitleNotFound;
import io.titleflix.exception.UserNotFound;

@Repository
public class CommentRateRepositoryImp implements CommentRateRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public CommentRating reviewTitle(CommentRating review) throws UserNotFound, TitleNotFound {
		// TODO Auto-generated method stub		
		em.persist(review);
		//Code to update the Average Rating of a Title
		Double averageValue = averagerating(review.getMovieId().getMovieId());
		Title existingTitle = review.getMovieId();
		existingTitle.setAverageRating(averageValue);
		em.merge(existingTitle);
		return review;
	}

	private Double averagerating(String movieId) {
		// TODO Auto-generated method stub
	//	TypedQuery<Double> averageQuery = (TypedQuery<Double>) em.createQuery("SELECT AVG(r.rating) FROM CommentRating r WHERE movieId_movieId = :pmovieId");
		TypedQuery<Double> averageQuery = (TypedQuery<Double>) em.createNamedQuery("Rating.averageQuery");
		averageQuery.setParameter("pmovieId", movieId);
		Double averageRating = averageQuery.getSingleResult();
		return averageRating;
	}

	@Override
	public List<CommentRating> viewAllReviwes() {
		// TODO Auto-generated method stub

	//	TypedQuery<CommentRating> reiewListQuery = em.createQuery("select r from CommentRating r", CommentRating.class);
		TypedQuery<CommentRating> reiewListQuery = em.createNamedQuery("Comment.findAll",CommentRating.class);
		List<CommentRating> reiewList = reiewListQuery.getResultList();
		return reiewList;
	}

	@Override
	public List<CommentRating> viewReviewsTitle(String movieId) {
		// TODO Auto--generated method stub
//		TypedQuery<CommentRating> reviewQuery = em
//				.createQuery("select r from CommentRating r where movieId_movieId = :pmovieId", CommentRating.class);
		TypedQuery<CommentRating> reviewQuery = em.createNamedQuery("Reviews.ofTitle",CommentRating.class);
		reviewQuery.setParameter("pmovieId", movieId);
		List<CommentRating> reviewList = reviewQuery.getResultList();
		return reviewList;
	}

	@Override
	public void deleteReviewTitle(List<CommentRating> checkRating) {
		// TODO Auto-generated method stub
		
		for (CommentRating commentRating : checkRating) {
			em.remove(commentRating);
		}
		
		
	}

}
