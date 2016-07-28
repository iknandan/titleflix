package io.titleflix.repository;

import java.util.List;

import io.titleflix.entity.CommentRating;
import io.titleflix.exception.TitleNotFound;
import io.titleflix.exception.UserNotFound;

public interface CommentRateRepository {

	public CommentRating reviewTitle(CommentRating review) throws UserNotFound, TitleNotFound;

	public List<CommentRating> viewAllReviwes();

	public List<CommentRating> viewReviewsTitle(String movieId);

	public void deleteReviewTitle(List<CommentRating> checkRating);

}
