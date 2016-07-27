package io.titleflix.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import io.titleflix.entity.CommentRating;
import io.titleflix.entity.Genre;
import io.titleflix.entity.Title;

@Repository
public class TitleRepositoryImp implements TitleRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Title> findAllTitles() {
		// TODO Auto-generated method stub
		TypedQuery<Title> titleQuery = em.createQuery("select t from Title t", Title.class);
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
		TypedQuery<Title> filterQuery = em.createQuery("select t from Title t where t.type = :ptype ", Title.class);
		filterQuery.setParameter("ptype", type);
		List<Title> filteredResult = filterQuery.getResultList();
		return filteredResult;
	}

	@Override
	public List<Title> filterByYear(String year) {
		// TODO Auto-generated method stub
		TypedQuery<Title> filterQuery = em.createQuery("select t from Title t where t.year = :pyear ", Title.class);
		filterQuery.setParameter("pyear", year);
		List<Title> filteredResult = filterQuery.getResultList();
		return filteredResult;

	}

	@Override
	public List<Title> sortByYear() {
		// TODO Auto-generated method stub
		TypedQuery<Title> sortedQuery = em.createQuery("select t from Title t order by (t.year+0) desc", Title.class);
		List<Title> sortedTitleList = sortedQuery.getResultList();
		return sortedTitleList;
	}

	@Override
	public List<Title> sortByImdbRating() {
		// TODO Auto-generated method stub
		TypedQuery<Title> sortedQuery = em.createQuery("select t from Title t order by (t.imdbRating+0) desc",
				Title.class);
		List<Title> sortedTitleList = sortedQuery.getResultList();
		return sortedTitleList;
	}

	@Override
	public List<Title> sortByImdbVotes() {
		// TODO Auto-generated method stub
		TypedQuery<Title> sortedQuery = em.createQuery("select t from Title t order by (t.imdbVotes+0) desc",
				Title.class);
		List<Title> sortedTitleList = sortedQuery.getResultList();
		return sortedTitleList;
	}

	@Override
	public List<Title> topRatedMovies() {
		// TODO Auto-generated method stub
		TypedQuery<Title> ratedQuery = em.createQuery(
				"select t from Title t where t.imdbRating >= 9 and t.type = 'movie' order by (t.imdbRating+0) desc ",
				Title.class);
		List<Title> ratedTitleList = ratedQuery.getResultList();
		return ratedTitleList;
	}

	@Override
	public List<Title> topRatedSeries() {
		// TODO Auto-generated method stub

		TypedQuery<Title> ratedQuery = em.createQuery(
				"select t from Title t where t.imdbRating >= 9 and t.type = 'series' order by (t.imdbRating+0) desc ",
				Title.class);
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
		TypedQuery<Title> filterQuery = em
				.createQuery("select t from Title t where t.year = :pyear and t.type = :ptype ", Title.class);
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
