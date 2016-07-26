package io.titleflix.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.titleflix.entity.Title;
import io.titleflix.exception.NoTitlesPresent;
import io.titleflix.service.TitleService;

@RestController
@RequestMapping(value = "/title")
public class TitleController {

	@Autowired
	private TitleService titleService;

	// To Browse All Titles
	@RequestMapping(value = "/viewAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> findAllTitles() throws NoTitlesPresent {

		List<Title> existing = titleService.findAllTitles();
		return existing;
	}

	// Filter Catalog based on type
	@RequestMapping(value = "/filterByType/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> filterByType(@PathVariable(value = "type") String type) throws NoTitlesPresent {
		List<Title> fliteredTitles = titleService.filterByType(type);
		return fliteredTitles;
	}

	// Filter Catalog based on year
	@RequestMapping(value = "/filterByYear/{year}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> filterByYear(@PathVariable(value = "year") String year) throws NoTitlesPresent {
		List<Title> fliteredTitles = titleService.filterByYear(year);
		return fliteredTitles;
	}

	// Sorting catalog based on Year in Descending order
	@RequestMapping(value = "/sortByYear", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> sortByYear() throws NoTitlesPresent {
		List<Title> sortedTitles = titleService.sortByYear();
		return sortedTitles;

	}

	// Sorting catalog based on IMDB Ratings in Descending order
	@RequestMapping(value = "/sortByImdbRating", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> sortByImdbRating() throws NoTitlesPresent {
		List<Title> sortedTitles = titleService.sortByImdbRating();
		return sortedTitles;

	}

	// Sorting catalog based on IMDB Votes in Descending order
	@RequestMapping(value = "/sortByImdbVotes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> sortByImdbVotes() throws NoTitlesPresent {
		List<Title> sortedTitles = titleService.sortByImdbVotes();
		return sortedTitles;
	}

	// TOP RATED MOVIES as per IMDB Rating (>=9)
	@RequestMapping(value = "/topRatedMovies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> topRatedMovies() throws NoTitlesPresent {
		List<Title> ratedMovies = titleService.topRatedMovies();
		return ratedMovies;
	}
	
	// TOP RATED SERIES as per IMDB Rating (>=9)
		@RequestMapping(value = "/topRatedSeries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Title> topRatedSeries() throws NoTitlesPresent {
			List<Title> ratedSeries = titleService.topRatedSeries();
			return ratedSeries;
		}

}
