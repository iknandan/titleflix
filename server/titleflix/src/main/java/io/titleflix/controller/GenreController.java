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
import io.titleflix.service.GenreServiceImp;

@RestController
@RequestMapping(value="/genre")
public class GenreController {
	
	@Autowired
	private GenreService genreService; 
	
	//Filter Catalog based on Genre
	@RequestMapping(value="/filterByGenre/{genreId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> filterByGenre(@PathVariable(value="genreId")String genreId) throws NoTitleForGenre {
		List<Title> titleList = genreService.filterByGenre(genreId);
		
		return titleList;
	}
	
	//List all the Genre present in the database - For frontEnd use only
	@RequestMapping(value="/viewAll",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Genre> viewAllGenre() throws NoGenreFound{
		List<Genre> genreList = genreService.viewAllGenre();
		return genreList;
	}
	
	

}
