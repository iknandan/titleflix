package io.titleflix.repository;

import java.util.List;

import io.titleflix.entity.Title;

public interface TitleRepository {

	public List<Title> findAllTitles();

}
