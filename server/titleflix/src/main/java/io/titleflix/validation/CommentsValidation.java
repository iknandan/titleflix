package io.titleflix.validation;

import org.springframework.stereotype.Component;

import io.titleflix.entity.CommentRating;
import io.titleflix.exception.ValidComment;
import io.titleflix.exception.ValidRating;
import io.titleflix.exception.ValidTitleId;
import io.titleflix.exception.ValidUserID;
/**
 * This class is used to validate all teh movie Reviews inputs.
 * @author  nandan
 *
 */
@Component
public class CommentsValidation {
	// Validates all the review inputs of a Title 
	public CommentRating reviewValidation(CommentRating review) throws ValidTitleId, ValidUserID, ValidComment, ValidRating {
		// TODO Auto-generated method stub
		if(review.getMovieId().getMovieId() == "" || review.getMovieId().getMovieId() == null){
			throw new ValidTitleId();
		}
		else if(review.getUserId().getId() == "" || review.getUserId().getId() == null){
			throw new ValidUserID();
		}
		else if(review.getComment() == null || review.getComment()== ""){
			throw new ValidComment();
		}
		else if(review.getRating() < 0 || review.getRating() > 5 ){
			throw new ValidRating();
		}
		return review; 
	}

}
