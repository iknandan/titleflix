package io.titleflix.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import io.titleflix.entity.Title;
import io.titleflix.exception.NoTitlesPresent;
import io.titleflix.exception.TitleFieldValidation;
import io.titleflix.exception.TitleNotFound;
import io.titleflix.service.TitleService;

/**
 * This controller is used to performe all the operations on the Title Entity.
 * It uses GET, POST, PUT and DELETE request
 * 
 * @author nandan
 *
 */
@RestController
@RequestMapping(path = "/title")
public class TitleController {

	@Autowired
	private TitleService titleService;

	// To Browse All Titles
	@RequestMapping(path = "/viewAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> findAllTitles() throws NoTitlesPresent {

		List<Title> existing = titleService.findAllTitles();
		return existing;
	}

	// // Filter Catalog based on type
	// @RequestMapping(path = "/filterByType/{type}", method =
	// RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	// public List<Title> filterByType(@PathVariable(value = "type") String
	// type) throws NoTitlesPresent {
	// List<Title> fliteredTitles = titleService.filterByType(type);
	// return fliteredTitles;
	// }
	//
	// // Filter Catalog based on year
	// @RequestMapping(path = "/filterByYear/{year}", method =
	// RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	// public List<Title> filterByYear(@PathVariable(value = "year") String
	// year) throws NoTitlesPresent {
	// List<Title> fliteredTitles = titleService.filterByYear(year);
	// return fliteredTitles;
	// }

	// Filter Catalog - common functionality - improvised code
	@RequestMapping(path = "/filterBy/{basedOn}/{value}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> filterByModified(@PathVariable(value = "basedOn") String basedOn,
			@PathVariable(value = "value") String value) throws NoTitlesPresent {
		System.out.println(basedOn + " " + value);
		List<Title> fliteredTitles = titleService.filterByModified(basedOn, value);
		return fliteredTitles;
	}

	// List of years present from database
	@RequestMapping(path = "/yearList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<String> yearList() {
		List<String> existingYears = titleService.yearList();
		return existingYears;
	}

	// List of type present from database
	@RequestMapping(path = "/typeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<String> typeList() {
		List<String> existingYears = titleService.typeList();
		return existingYears;
	}

	// Filter Catalog based on year and type - Used for frontEnd.
	@RequestMapping(path = "/filterByYearType/{type}/{year}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> filterByYear(@PathVariable(value = "type") String type,
			@PathVariable(value = "year") String year) throws NoTitlesPresent {
		List<Title> fliteredTitles = titleService.filterByYear(year, type);
		return fliteredTitles;
	}

//	// Sorting catalog based on Year in Descending order
//	@RequestMapping(path = "/sortByYear", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public List<Title> sortByYear() throws NoTitlesPresent {
//		List<Title> sortedTitles = titleService.sortByYear();
//		return sortedTitles;
//	}
//
//	// Sorting catalog based on IMDB Ratings in Descending order
//	@RequestMapping(path = "/sortByImdbRating", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public List<Title> sortByImdbRating() throws NoTitlesPresent {
//		List<Title> sortedTitles = titleService.sortByImdbRating();
//		return sortedTitles;
//	}
//
//	// Sorting catalog based on IMDB Votes in Descending order
//	@RequestMapping(path = "/sortByImdbVotes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public List<Title> sortByImdbVotes() throws NoTitlesPresent {
//		List<Title> sortedTitles = titleService.sortByImdbVotes();
//		return sortedTitles;
//	}

	// TOP RATED MOVIES as per IMDB Rating (>=9)
	@RequestMapping(path = "/topRatedMovies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> topRatedMovies() throws NoTitlesPresent {
		List<Title> ratedMovies = titleService.topRatedMovies();
		return ratedMovies;
	}

	// TOP RATED SERIES as per IMDB Rating (>=9)
	@RequestMapping(path = "/topRatedSeries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> topRatedSeries() throws NoTitlesPresent {
		List<Title> ratedSeries = titleService.topRatedSeries();
		return ratedSeries;
	}

	// Functionality to view a Title Details
	@RequestMapping(path = "/viewTitleDetails/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title viewTitleDetails(@PathVariable(value = "id") String id) throws TitleNotFound {
		Title titleDetails = titleService.viewTitleDetails(id);
		return titleDetails;
	}

	// Link to IMDB Site
	@RequestMapping(path = "imdbSiteNavigate/{imdbId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView toImdbSite(@PathVariable(value = "imdbId") String imdbId) {
		String imbdSite = "http://www.imdb.com/title/" + imdbId;
		return new ModelAndView("redirect:" + imbdSite);
	}

	// Create a Title - Admin functionality
	@RequestMapping(path = "/createTitle", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title createTitle(@RequestBody Title title) throws TitleFieldValidation {
		Title newTitle = titleService.createTitle(title);
		return newTitle;
	}

	// Update a Title - Admin functionality
	@RequestMapping(path = "/updateTitle/{movieId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title updateTitle(@PathVariable(value = "movieId") String movieId, @RequestBody Title title)
			throws NoTitlesPresent, TitleFieldValidation {
		Title updateTitle = titleService.updateTitle(movieId, title);
		return updateTitle;
	}

	// Delete a Title - Admin functionality
	@RequestMapping(path = "/deleteTitle/{movieId}", method = RequestMethod.DELETE)
	public void deleteTitle(@PathVariable(value = "movieId") String movieId) throws TitleNotFound {
		titleService.deleteTitle(movieId);
	}
}
