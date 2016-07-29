package io.titleflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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


@Service
@Transactional
public class CommentRateServiceImp implements CommentRateService{
	@Autowired
	private CommentRateRepository reviewRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TitleRepository titleRepository;
	
	@Override
	public CommentRating reviewTitle(CommentRating review) throws ValidTitleId, ValidUserID, ValidComment, ValidRating, UserNotFound, TitleNotFound {
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
		else{
			String userId = review.getUserId().getId();
			User existingUser = userRepository.findByUserId(userId);
			if(existingUser == null ){
				throw new UserNotFound();
			}
			String movieId = review.getMovieId().getMovieId();
			Title existingTitle = titleRepository.viewTitleDetails(movieId);
			if(existingTitle == null ){
				throw new TitleNotFound();
			}
			review.setUserId(existingUser);
			review.setMovieId(existingTitle);
			CommentRating existingReview = reviewRepository.reviewTitle(review);
			return existingReview;
		}
		
	}
	
	
	 
	@Override
	public List<CommentRating> viewAllReviwes() {
		// TODO Auto-generated method stub
		
		return reviewRepository.viewAllReviwes();
	}



	@Override
	public List<CommentRating> viewReviewsTitle(String movieId) throws NoReviewsFound {
		// TODO Auto-generated method stub
		List<CommentRating> viewReviwes = reviewRepository.viewReviewsTitle(movieId);
		if(viewReviwes.isEmpty()){
		throw new NoReviewsFound();	
		}
		else{
			return viewReviwes;
		}
		
	}

}
