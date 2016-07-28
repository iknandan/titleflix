package io.titleflix.service;

import java.util.List;

import io.titleflix.entity.Title;
import io.titleflix.exception.NoTitlesPresent;
import io.titleflix.exception.TitleFieldValidation;
import io.titleflix.exception.TitleNotFound;

public interface TitleService {

	public List<Title> findAllTitles() throws NoTitlesPresent;

	public List<Title> filterByType(String type) throws NoTitlesPresent;

	public List<Title> filterByYear(String year) throws NoTitlesPresent;

	public List<Title> sortByYear() throws NoTitlesPresent;

	public List<Title> sortByImdbRating() throws NoTitlesPresent;

	public List<Title> sortByImdbVotes() throws NoTitlesPresent;

	public List<Title> topRatedMovies() throws NoTitlesPresent;

	public List<Title> topRatedSeries() throws NoTitlesPresent;

	public Title viewTitleDetails(String id) throws TitleNotFound;

	public List<Title> filterByYear(String year, String type) throws NoTitlesPresent;

	public Title createTitle(Title title) throws TitleFieldValidation;

	public Title updateTitle(String movieId, Title title) throws NoTitlesPresent, TitleFieldValidation;

	public void deleteTitle(String movieId) throws  TitleNotFound;

}
