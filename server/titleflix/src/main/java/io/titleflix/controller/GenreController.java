package io.titleflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.titleflix.entity.Genre;
import io.titleflix.entity.Title;
import io.titleflix.exception.NoGenreFound;
import io.titleflix.exception.NoTitleForGenre;
import io.titleflix.service.GenreService;

/**
 * This controller class is used to get the Titles based on the genre selected
 * 
 * @author nandan
 *
 */
@RestController
@RequestMapping(path = "/genre")
public class GenreController {

	@Autowired
	private GenreService genreService;

	// This functionality is used to Filter Catalog based on Genre
	@RequestMapping(path = "/filterByGenre/{genre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> filterByGenre(@PathVariable(value = "genre") String genre) throws NoTitleForGenre {
		List<Title> titleList = genreService.filterByGenre(genre);
		return titleList;
	}

	// List all the Genre present in the database - For frontEnd use only
	@RequestMapping(path = "/viewAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Genre> viewAllGenre() throws NoGenreFound {
		List<Genre> genreList = genreService.viewAllGenre();
		return genreList;
	}

	// Filter Catalog based on Genre and Type - for front End use only
	@RequestMapping(path = "/filterByGenreType/{type}/{genre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> filterByGenre(@PathVariable(value = "type") String type,
			@PathVariable(value = "genre") String genre) throws NoTitleForGenre {
		List<Title> titleList = genreService.filterByGenre(type, genre);
		return titleList;
	}

}
