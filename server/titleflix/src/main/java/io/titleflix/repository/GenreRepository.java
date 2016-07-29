package io.titleflix.repository;

import java.util.List;

import io.titleflix.entity.Genre;
import io.titleflix.entity.Title;

public interface GenreRepository {

	public List<Title> filterByGenre(String genreId);

	public List<Genre> viewAllGenre();

	public List<Title> filterByGenre(String type, String genreId);

}
