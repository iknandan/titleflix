package io.titleflix.service;

import java.util.List;

import io.titleflix.entity.Title;
import io.titleflix.exception.NoTitlesPresent;

public interface TitleService {

	public List<Title> findAllTitles() throws NoTitlesPresent;



	public List<Title> filterByType(String type) throws NoTitlesPresent;



	public List<Title> filterByYear(String year) throws NoTitlesPresent;



	public List<Title> sortByYear() throws NoTitlesPresent;



	public List<Title> sortByImdbRating() throws NoTitlesPresent;



	public List<Title> sortByImdbVotes() throws NoTitlesPresent;

}
