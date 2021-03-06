package io.titleflix.repository;

import java.util.List;
import io.titleflix.entity.Title;

public interface TitleRepository {

	public List<Title> findAllTitles();

	public List<Title> filterByType(String type);

	public List<Title> filterByYear(String year);

	public List<Title> sortByYear();

	public List<Title> sortByImdbRating();

	public List<Title> sortByImdbVotes();

	public List<Title> topRatedMovies();

	public List<Title> topRatedSeries();

	public Title viewTitleDetails(String id);

	public List<Title> filterByYear(String year, String type);

	public Title createTitle(Title title);

	public Title updateTitle(Title title);

	public void deleteTitle(String movieId);

	



}
