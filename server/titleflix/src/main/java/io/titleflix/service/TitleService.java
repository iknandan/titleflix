package io.titleflix.service;

import java.util.List;

import io.titleflix.entity.Title;
import io.titleflix.exception.NoTitlesPresent;

public interface TitleService {

	public List<Title> findAllTitles() throws NoTitlesPresent;

}
