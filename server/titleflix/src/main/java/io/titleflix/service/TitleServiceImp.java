package io.titleflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.titleflix.entity.CommentRating;
import io.titleflix.entity.Title;
import io.titleflix.exception.NoTitlesPresent;
import io.titleflix.exception.TitleFieldValidation;
import io.titleflix.exception.TitleNotFound;
import io.titleflix.repository.CommentRateRepository;
import io.titleflix.repository.TitleRepository;
import io.titleflix.validation.TitleValidation;

/**
 * This is a Title Service layer where all the business logic and validations
 * are implemented
 * 
 * @author nandan
 *
 */
@Service
@Transactional
public class TitleServiceImp implements TitleService {

	@Autowired
	private TitleRepository titleRepository;
	@Autowired
	private CommentRateRepository reviewRepository;
	@Autowired
	private TitleValidation titleValidation;

	@Override
	// To Browse All Titles
	public List<Title> findAllTitles() throws NoTitlesPresent {
		List<Title> existingTitles = titleRepository.findAllTitles();
		if (existingTitles != null) {
			return existingTitles;
		} else {
			throw new NoTitlesPresent();
		}
	}

	// Filter Catalog based on type
	@Override
	public List<Title> filterByType(String type) throws NoTitlesPresent {
		List<Title> filterdTitles = titleRepository.filterByType(type);
		if (filterdTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {
			return filterdTitles;
		}
	}

	// Filter Catalog based on year
	@Override
	public List<Title> filterByYear(String year) throws NoTitlesPresent {
		List<Title> filterdTitles = titleRepository.filterByYear(year);
		if (filterdTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {
			return filterdTitles;
		}

	}

	// Sorting catalog based on Year in Descending order
	@Override
	public List<Title> sortByYear() throws NoTitlesPresent {
		List<Title> sortedTitles = titleRepository.sortByYear();
		if (sortedTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {
			return sortedTitles;
		}
	}

	// Sorting catalog based on IMDB Ratings in Descending order
	@Override
	public List<Title> sortByImdbRating() throws NoTitlesPresent {
		List<Title> sortedTitles = titleRepository.sortByImdbRating();
		if (sortedTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {
			return sortedTitles;
		}

	}

	// Sorting catalog based on IMDB Votes in Descending order
	@Override
	public List<Title> sortByImdbVotes() throws NoTitlesPresent {
		List<Title> sortedTitles = titleRepository.sortByImdbVotes();
		if (sortedTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {
			return sortedTitles;
		}
	}

	// TOP RATED MOVIES as per IMDB Rating (>=9)
	@Override
	public List<Title> topRatedMovies() throws NoTitlesPresent {
		List<Title> ratedTitles = titleRepository.topRatedMovies();
		if (ratedTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {
			return ratedTitles;
		}
	}

	// TOP RATED SERIES as per IMDB Rating (>=9)
	@Override
	public List<Title> topRatedSeries() throws NoTitlesPresent {
		List<Title> ratedTitles = titleRepository.topRatedSeries();
		if (ratedTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {
			return ratedTitles;
		}
	}

	// Functionality to view a Title Details
	@Override
	public Title viewTitleDetails(String id) throws TitleNotFound {
		Title titleDetail = titleRepository.viewTitleDetails(id);
		if (titleDetail != null) {
			return titleDetail;
		} else {
			throw new TitleNotFound();
		}
	}

	// Filter Catalog based on year and type - Used for frontEnd.
	@Override
	public List<Title> filterByYear(String year, String type) throws NoTitlesPresent {
		List<Title> filterdTitles = titleRepository.filterByYear(year, type);
		if (filterdTitles.isEmpty()) {
			throw new NoTitlesPresent();
		} else {
			return filterdTitles;
		}
	}

	// Create a Title - Admin functionality
	@Override
	public Title createTitle(Title title) throws TitleFieldValidation {
		Title validateTitle = titleValidation.validateTitle(title);
		Title newTitle = titleRepository.createTitle(validateTitle);
		return newTitle;
	}

	// Update a Title - Admin functionality
	@Override
	public Title updateTitle(String movieId, Title title) throws NoTitlesPresent, TitleFieldValidation {
		Title validateTitle = titleValidation.validateTitle(title);
		Title checkTitle = titleRepository.viewTitleDetails(movieId);
		if (checkTitle != null) {
			Title existingTitle = titleRepository.updateTitle(validateTitle);
			return existingTitle;
		} else {
			throw new NoTitlesPresent();
		}
	}

	// Delete a Title - Admin functionality
	@Override
	public void deleteTitle(String movieId) throws TitleNotFound {
		Title existingTitle = titleRepository.viewTitleDetails(movieId);
		if (existingTitle != null) {
			List<CommentRating> checkRating = reviewRepository.viewReviewsTitle(movieId);
			if (checkRating.isEmpty()) {
				titleRepository.deleteTitle(movieId);
			} else {
				reviewRepository.deleteReviewTitle(checkRating);
				// titleRepository.deleteTitle(movieId);
			}
		} else {
			throw new TitleNotFound();
		}

	}

	@Override
	public List<Title> filterByModified(String basedOn, String value) {
		// TODO Auto-generated method stub
		System.out.println("controller "+basedOn+" "+value);
		List<Title> filteredList = titleRepository.filterByYearModified(basedOn,value);
		return filteredList;
	}

	@Override
	public List<String> yearList() {
		// TODO Auto-generated method stub
		List<String> existingYears = titleRepository.yearList();
		return existingYears;
	}

	@Override
	public List<String> typeList() {
		// TODO Auto-generated method stub
		List<String> existingType = titleRepository.typeList();
		return existingType;
		
	}

	@Override
	public List<Title> sortBy(String basedOn) {
		// TODO Auto-generated method stub
		List<Title> existingList = titleRepository.sortBy(basedOn);
		return existingList;
	}

}
