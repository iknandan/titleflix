package io.titleflix.service;

import java.util.List;

import io.titleflix.entity.CommentRating;
import io.titleflix.exception.NoReviewsFound;
import io.titleflix.exception.TitleNotFound;
import io.titleflix.exception.UserNotFound;
import io.titleflix.exception.ValidComment;
import io.titleflix.exception.ValidRating;
import io.titleflix.exception.ValidTitleId;
import io.titleflix.exception.ValidUserID;

public interface CommentRateService {

	public CommentRating reviewTitle(CommentRating review) throws ValidTitleId, ValidUserID, ValidComment, ValidRating, UserNotFound, TitleNotFound;

	public List<CommentRating> viewAllReviwes();

	public List<CommentRating> viewReviewsTitle(String movieId) throws NoReviewsFound;

}
