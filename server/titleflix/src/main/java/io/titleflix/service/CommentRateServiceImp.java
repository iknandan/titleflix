package io.titleflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.titleflix.entity.CommentRating;
import io.titleflix.exception.NoReviewsFound;
import io.titleflix.repository.CommentRateRepository;


@Service
@Transactional
public class CommentRateServiceImp implements CommentRateService{
	@Autowired
	private CommentRateRepository reviewRepository;
	
	@Override
	public CommentRating reviewTitle(CommentRating review) {
		// TODO Auto-generated method stub
		CommentRating existingReview = reviewRepository.reviewTitle(review);
		return existingReview;
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
