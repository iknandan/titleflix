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
import io.titleflix.repository.GenreRepositoryImp;

@Service
@Transactional
public class GenreServiceImp implements GenreService {
	
	@Autowired
	private GenreRepository genreRepository;

	@Override
	public List<Title> filterByGenre(String genreId) throws NoTitleForGenre {
		// TODO Auto-generated method stub
		List<Title> existingTitles = genreRepository.filterByGenre(genreId);
		if(existingTitles.isEmpty()){
			throw new NoTitleForGenre();
		}
		else{
			return existingTitles;
		}
		
	}

	@Override
	public List<Genre> viewAllGenre() throws NoGenreFound {
		// TODO Auto-generated method stub
		
		List<Genre> existingGenre = genreRepository.viewAllGenre();
		if(existingGenre.isEmpty()){
			throw new NoGenreFound();
		}
		else{
			return existingGenre;
		}
		
	}

	

	
}
