package io.titleflix.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.titleflix.entity.Genre;
import io.titleflix.entity.Title;
import io.titleflix.exception.NoGenreFound;
import io.titleflix.exception.NoTitleForGenre;
import io.titleflix.repository.GenreRepository;

/**
 * This is a Genre Service layer where all the business logic is implemented
 * 
 * @author nandan
 *
 */
@Service
@Transactional
public class GenreServiceImp implements GenreService {

	@Autowired
	private GenreRepository genreRepository;

	// This functionality is used to filter the catalog based on the genre
	// selected
	@Override
	public List<Title> filterByGenre(String genre) throws NoTitleForGenre {
		List<Title> existingTitles = genreRepository.filterByGenre(genre);
		if (existingTitles.isEmpty()) {
			throw new NoTitleForGenre();
		} else {
			return existingTitles;
		}

	}

	// This functionality is used to view all the Genres present - For front end
	// use only
	@Override
	public List<Genre> viewAllGenre() throws NoGenreFound {
		List<Genre> existingGenre = genreRepository.viewAllGenre();
		if (existingGenre.isEmpty()) {
			throw new NoGenreFound();
		} else {
			return existingGenre;
		}

	}

	// This functionality is used to filter cataloge based on the type and the
	// genre selected - for front End use
	@Override
	public List<Title> filterByGenre(String type, String genre) throws NoTitleForGenre {
		List<Title> existingTitles = genreRepository.filterByGenre(type, genre);
		if (existingTitles.isEmpty()) {
			throw new NoTitleForGenre();
		} else {
			return existingTitles;
		}

	}
}
