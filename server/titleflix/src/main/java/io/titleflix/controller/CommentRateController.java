package io.titleflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.titleflix.entity.CommentRating;
import io.titleflix.exception.NoReviewsFound;
import io.titleflix.exception.TitleNotFound;
import io.titleflix.exception.UserNotFound;
import io.titleflix.exception.ValidComment;
import io.titleflix.exception.ValidRating;
import io.titleflix.exception.ValidTitleId;
import io.titleflix.exception.ValidUserID;
import io.titleflix.service.CommentRateService;


@RestController
@RequestMapping(path = "/comment")
public class CommentRateController {
	
	@Autowired
	private CommentRateService reviewService;
	//Commenting and Rating a Title
	@RequestMapping(path = "/reviewTitle", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CommentRating reviewTitle(@RequestBody CommentRating review) throws ValidTitleId, ValidUserID, ValidComment, ValidRating, UserNotFound, TitleNotFound {

		CommentRating existingComment = reviewService.reviewTitle(review);
		return existingComment;
	}
	
	@RequestMapping(path="/viewReviews/{movieId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<CommentRating> viewReviewsTitle(@PathVariable(value="movieId") String movieId) throws NoReviewsFound {
		List<CommentRating> existingReviews = reviewService.viewReviewsTitle(movieId);
		return existingReviews;
	}
	
	// List all Rating - demo method
	@RequestMapping(path = "/reviewList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<CommentRating> viewAllReviews() {

		List<CommentRating> existingList = reviewService.viewAllReviwes();
		return existingList;
	}
}
