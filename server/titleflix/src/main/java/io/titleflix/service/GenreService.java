package io.titleflix.service;

import java.util.List;

import io.titleflix.entity.Genre;
import io.titleflix.entity.Title;
import io.titleflix.exception.NoGenreFound;
import io.titleflix.exception.NoTitleForGenre;

public interface GenreService {

	public List<Title> filterByGenre(String genreId) throws NoTitleForGenre;

	public List<Genre> viewAllGenre() throws NoGenreFound;

	public List<Title> filterByGenre(String type, String genreId) throws NoTitleForGenre;

}
