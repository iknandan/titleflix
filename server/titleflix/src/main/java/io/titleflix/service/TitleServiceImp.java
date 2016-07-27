package io.titleflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.titleflix.entity.CommentRating;
import io.titleflix.entity.Genre;
import io.titleflix.entity.Title;
import io.titleflix.exception.NoTitlesPresent;
import io.titleflix.exception.TitleNotFound;
import io.titleflix.repository.CommentRateRepository;
import io.titleflix.repository.TitleRepository;

@Service
@Transactional
public class TitleServiceImp implements TitleService {

	@Autowired
	private TitleRepository titleRepository;
	@Autowired
	private CommentRateRepository reviewRepository;
	@Override
	public List<Title> findAllTitles() throws NoTitlesPresent {
		// TODO Auto-generated method stub
		List<Title> existingTitles = titleRepository.findAllTitles();
		if (existingTitles != null) {
			return existingTitles;
		} else {
			throw new NoTitlesPresent();
		}

	}

	@Override
	public List<Title> filterByType(String type) throws NoTitlesPresent {
		// TODO Auto-generated method stub
		List<Title> filterdTitles = titleRepository.filterByType(type);
		if (filterdTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {
			return filterdTitles;
		}

	}

	@Override
	public List<Title> filterByYear(String year) throws NoTitlesPresent {
		// TODO Auto-generated method stub
		List<Title> filterdTitles = titleRepository.filterByYear(year);
		if (filterdTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {
			return filterdTitles;
		}

	}

	@Override
	public List<Title> sortByYear() throws NoTitlesPresent {
		// TODO Auto-generated method stub
		List<Title> sortedTitles = titleRepository.sortByYear();
		if (sortedTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {
			return sortedTitles;
		}
	}

	@Override
	public List<Title> sortByImdbRating() throws NoTitlesPresent {
		// TODO Auto-generated method stub
		List<Title> sortedTitles = titleRepository.sortByImdbRating();
		if (sortedTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {
			return sortedTitles;
		}

	}

	@Override
	public List<Title> sortByImdbVotes() throws NoTitlesPresent {
		// TODO Auto-generated method stub
		List<Title> sortedTitles = titleRepository.sortByImdbVotes();
		if (sortedTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {
			return sortedTitles;
		}
	}

	@Override
	public List<Title> topRatedMovies() throws NoTitlesPresent {
		// TODO Auto-generated method stub
		List<Title> ratedTitles = titleRepository.topRatedMovies();
		if (ratedTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {

			return ratedTitles;
		}

	}

	@Override
	public List<Title> topRatedSeries() throws NoTitlesPresent {
		// TODO Auto-generated method stub
		List<Title> ratedTitles = titleRepository.topRatedSeries();
		if (ratedTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {

			return ratedTitles;
		}

	}

	@Override
	public Title viewTitleDetails(String id) throws TitleNotFound {
		// TODO Auto-generated method stub
		Title titleDetail = titleRepository.viewTitleDetails(id);
		if (titleDetail != null) {
			return titleDetail;
		} else {
			throw new TitleNotFound();
		}
	}

	@Override
	public List<Title> filterByYear(String year, String type) throws NoTitlesPresent {
		// TODO Auto-generated method stub
		List<Title> filterdTitles = titleRepository.filterByYear(year, type);
		if (filterdTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {
			return filterdTitles;
		}

	}

	@Override
	public Title createTitle(Title title) {
		// TODO Auto-generated method stub
		System.out.println("createTitle service");
		Title newTitle = titleRepository.createTitle(title);
		return newTitle;
	}

	@Override
	public Title updateTitle(String movieId, Title title) throws NoTitlesPresent {
		// TODO Auto-generated method stub
		Title checkTitle = titleRepository.viewTitleDetails(movieId);
		if (checkTitle != null) {
			Title existingTitle = titleRepository.updateTitle(title);
			return existingTitle;
		} else {
			throw new NoTitlesPresent();
		}

	}

	@Override
	public void deleteTitle(String movieId) throws  TitleNotFound {
		// TODO Auto-generated method stub
		Title existingTitle = titleRepository.viewTitleDetails(movieId);
		if(existingTitle != null){
			List<CommentRating> checkRating = reviewRepository.viewReviewsTitle(movieId);
			if(checkRating.isEmpty()){
			titleRepository.deleteTitle(movieId);
			}
			else{
				reviewRepository.deleteReviewTitle(checkRating);
				//titleRepository.deleteTitle(movieId);
			}
		}
		else{
			throw new TitleNotFound();
		}
		
	}

}
