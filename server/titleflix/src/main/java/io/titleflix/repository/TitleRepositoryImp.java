package io.titleflix.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.titleflix.entity.Genre;
import io.titleflix.entity.Title;

@Repository
public class TitleRepositoryImp implements TitleRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Title> findAllTitles() {
		// TODO Auto-generated method stub
		TypedQuery<Title> titleQuery = em.createNamedQuery("Title.findAll", Title.class);
		List<Title> titleList = titleQuery.getResultList();
		if (titleList.isEmpty()) {
			return null;
		} else {
			return titleList;
		}

	}

	@Override
	public List<Title> filterByType(String type) {
		// TODO Auto-generated method stub
		TypedQuery<Title> filterQuery = em.createNamedQuery("Title.filterByType", Title.class);
		filterQuery.setParameter("ptype", type);
		List<Title> filteredResult = filterQuery.getResultList();
		return filteredResult;
	}

	@Override
	public List<Title> filterByYear(String year) {
		// TODO Auto-generated method stub
		TypedQuery<Title> filterQuery = em.createNamedQuery("Title.filterByYear", Title.class);
		filterQuery.setParameter("pyear", year);
		List<Title> filteredResult = filterQuery.getResultList();
		return filteredResult;

	}

	@Override
	public List<Title> sortByYear() {
		// TODO Auto-generated method stub
		TypedQuery<Title> sortedQuery = em.createNamedQuery("Title.sortByYear", Title.class);
		List<Title> sortedTitleList = sortedQuery.getResultList();
		return sortedTitleList;
	}

	@Override
	public List<Title> sortByImdbRating() {
		// TODO Auto-generated method stub
		TypedQuery<Title> sortedQuery = em.createNamedQuery("Title.sortByImdbRating", Title.class);
		List<Title> sortedTitleList = sortedQuery.getResultList();
		return sortedTitleList;
	}

	@Override
	public List<Title> sortByImdbVotes() {
		// TODO Auto-generated method stub
		TypedQuery<Title> sortedQuery = em.createNamedQuery("Title.sortByImdbVotes", Title.class);
		List<Title> sortedTitleList = sortedQuery.getResultList();
		return sortedTitleList;
	}

	@Override
	public List<Title> topRatedMovies() {
		// TODO Auto-generated method stub
		TypedQuery<Title> ratedQuery = em.createNamedQuery("Title.topRatedMovies", Title.class);
		List<Title> ratedTitleList = ratedQuery.getResultList();
		return ratedTitleList;
	}

	@Override
	public List<Title> topRatedSeries() {
		// TODO Auto-generated method stub
		TypedQuery<Title> ratedQuery = em.createNamedQuery("Title.topRatedSeries", Title.class);
		List<Title> ratedTitleList = ratedQuery.getResultList();
		return ratedTitleList;
	}

	@Override
	public Title viewTitleDetails(String id) {
		// TODO Auto-generated method stub
		Title existingTitle = em.find(Title.class, id);
		return existingTitle;
	}

	@Override
	public List<Title> filterByYear(String year, String type) {
		// TODO Auto-generated method stub
		TypedQuery<Title> filterQuery = em.createNamedQuery("Title.filterByYearType", Title.class);
		filterQuery.setParameter("pyear", year);
		filterQuery.setParameter("ptype", type);
		List<Title> filteredResult = filterQuery.getResultList();
		return filteredResult;
	}

	@Override

	public Title createTitle(Title title) {
		// TODO Auto-generated method stub

		List<Genre> newGenre = title.getGenre();
		List<Genre> existingGnereLsit = checkGenre(newGenre);
		title.setGenre(null);
		title.setGenre(existingGnereLsit);
		em.persist(title);
		return title;
	}

	@Override
	public Title updateTitle(Title title) {
		// TODO Auto-generated method stub
		List<Genre> newGenre = title.getGenre();
		List<Genre> existingGnereLsit = checkGenre(newGenre);
		title.setGenre(null);
		title.setGenre(existingGnereLsit);
		em.merge(title);
		return title;

	}

	private List<Genre> checkGenre(List<Genre> newGenre) {
		// TODO Auto-generated method stub

		List<Genre> newList = new ArrayList<>();

		for (Genre checkGenre : newGenre) {
			TypedQuery<Genre> genreQuery = em.createQuery("select g from Genre g where g.genre = :pgenre", Genre.class);
			genreQuery.setParameter("pgenre", checkGenre.getGenre());
			List<Genre> existingGenre = genreQuery.getResultList();
			if (existingGenre.isEmpty()) {
				checkGenre.setGenreId(null);
				em.persist(checkGenre);
				TypedQuery<Genre> particularGnereQuery = em.createQuery("select g from Genre g where g.genre = :pgenre",
						Genre.class);
				particularGnereQuery.setParameter("pgenre", checkGenre.getGenre());
				Genre addedGenre = particularGnereQuery.getSingleResult();
				newList.add(addedGenre);
			} else {
				newList.add(existingGenre.get(0));

			}
		}

		return newList;
	}

	@Override
	public void deleteTitle(String movieId) {
		// TODO Auto-generated method stub

		Title existingTitle = viewTitleDetails(movieId);
		em.remove(existingTitle);

	}

}
