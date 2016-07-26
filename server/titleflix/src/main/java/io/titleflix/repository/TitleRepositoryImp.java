package io.titleflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

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
	Title existingTitle = em.find(Title.class,id);
		return existingTitle;
	}

	

}
