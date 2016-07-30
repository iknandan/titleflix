package io.titleflix.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.titleflix.entity.CommentRating;
import io.titleflix.entity.Title;
import io.titleflix.entity.User;
import io.titleflix.exception.NoReviewsFound;
import io.titleflix.exception.TitleNotFound;
import io.titleflix.exception.UserNotFound;
import io.titleflix.exception.ValidComment;
import io.titleflix.exception.ValidRating;
import io.titleflix.exception.ValidTitleId;
import io.titleflix.exception.ValidUserID;
import io.titleflix.repository.CommentRateRepository;
import io.titleflix.repository.TitleRepository;
import io.titleflix.repository.UserRepository;
import io.titleflix.validation.CommentsValidation;

/**
 * This is a CommentRate Service layer where all the business logic and input
 * validations of Commentandrating entity is implemented
 * 
 * @author nandan
 *
 */
@Service
@Transactional
public class CommentRateServiceImp implements CommentRateService {
	@Autowired
	private CommentRateRepository reviewRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TitleRepository titleRepository;
	@Autowired
	private CommentsValidation reviewValidation;

	@Override
	public CommentRating reviewTitle(CommentRating review)
			throws ValidTitleId, ValidUserID, ValidComment, ValidRating, UserNotFound, TitleNotFound {
		// Validates the Title Review
		CommentRating validateReview = reviewValidation.reviewValidation(review);
		// Find a User with a given userID
		String userId = validateReview.getUserId().getId();
		User existingUser = userRepository.findByUserId(userId);
		if (existingUser == null) {
			throw new UserNotFound();
		}
		// Find a Title with a given movieID
		String movieId = review.getMovieId().getMovieId();
		Title existingTitle = titleRepository.viewTitleDetails(movieId);
		if (existingTitle == null) {
			throw new TitleNotFound();
		}
		// Set the requried User and Title objects in the review Object
		review.setUserId(existingUser);
		review.setMovieId(existingTitle);
		// Functionality to persist the Review.
		CommentRating existingReview = reviewRepository.reviewTitle(review);
		return existingReview;

	}
	// This method is used to find all reviews - demo purpose only
	@Override
	public List<CommentRating> viewAllReviwes() {
		// TODO Auto-generated method stub

		return reviewRepository.viewAllReviwes();
	}
	// This functionality is used to find all the reviews of a particular Title
	@Override
	public List<CommentRating> viewReviewsTitle(String movieId) throws NoReviewsFound {
		// TODO Auto-generated method stub
		List<CommentRating> viewReviwes = reviewRepository.viewReviewsTitle(movieId);
		if (viewReviwes.isEmpty()) {
			throw new NoReviewsFound();
		} else {
			return viewReviwes;
		}

	}

}
