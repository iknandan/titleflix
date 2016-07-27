package io.titleflix.repository;

import java.util.List;

import io.titleflix.entity.CommentRating;

public interface CommentRateRepository {

	public CommentRating reviewTitle(CommentRating review);

	public List<CommentRating> viewAllReviwes();

	public List<CommentRating> viewReviewsTitle(String movieId);

	public void deleteReviewTitle(List<CommentRating> checkRating);

}
