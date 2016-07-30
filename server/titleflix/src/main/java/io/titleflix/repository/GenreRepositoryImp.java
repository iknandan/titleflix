package io.titleflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.titleflix.entity.Genre;
import io.titleflix.entity.Title;

/**
 * This is a Genre repository which retrives the data from database and returns
 * to the service layer
 * 
 * @author nandan
 *
 */
@Repository
public class GenreRepositoryImp implements GenreRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	// This functionality provides the list of titles based on genre
	public List<Title> filterByGenre(String genre) {
		// TODO Auto-generated method stub
		TypedQuery<Title> genreQuery = em.createNamedQuery("Genre.filterByGenre", Title.class);
		genreQuery.setParameter("pgenreId", genre);
		List<Title> titleList = genreQuery.getResultList();
		return titleList;
	}

	// This functionality provides all the genres present - front end use only
	@Override
	public List<Genre> viewAllGenre() {
		TypedQuery<Genre> genreListQuery = em.createNamedQuery("Gnere.viewAllGenre", Genre.class);
		List<Genre> genreList = genreListQuery.getResultList();
		return genreList;
	}

	// This functionality provides the list of titles based on genre and type
	// selected - for front End
	@Override
	public List<Title> filterByGenre(String type, String genre) {
		TypedQuery<Title> genreQuery = em.createNamedQuery("Gnere.filterByGenreType", Title.class);
		genreQuery.setParameter("pgenreId", genre);
		genreQuery.setParameter("ptype", type);
		List<Title> titleList = genreQuery.getResultList();
		return titleList;

	}

}
