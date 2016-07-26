package io.titleflix.service;

import java.util.List;

import io.titleflix.entity.CommentRating;

public interface CommentRateService {

	public CommentRating reviewTitle(CommentRating review);

	public List<CommentRating> viewAllReviwes();

}
