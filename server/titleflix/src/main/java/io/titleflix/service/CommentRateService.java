package io.titleflix.service;

import java.util.List;

import io.titleflix.entity.CommentRating;
import io.titleflix.exception.NoReviewsFound;

public interface CommentRateService {

	public CommentRating reviewTitle(CommentRating review);

	public List<CommentRating> viewAllReviwes();

	public List<CommentRating> viewReviewsTitle(String movieId) throws NoReviewsFound;

}
