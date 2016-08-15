package io.titleflix.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.titleflix.entity.Genre;
import io.titleflix.entity.Title;

/**
 * This is a Title Repository layer which queries the data and returns to the
 * Service layer
 * 
 * @author nandan
 *
 */
@Repository
public class TitleRepositoryImp implements TitleRepository {

	@PersistenceContext
	private EntityManager em;

	// Find all titles from database
	@Override
	public List<Title> findAllTitles() {
		TypedQuery<Title> titleQuery = em.createNamedQuery("Title.findAll", Title.class);
		List<Title> titleList = titleQuery.getResultList();
		if (titleList.isEmpty()) {
			return null;
		} else {
			return titleList;
		}

	}

	// Find all title based on type - movie or series
	@Override
	public List<Title> filterByType(String type) {
		TypedQuery<Title> filterQuery = em.createNamedQuery("Title.filterByType", Title.class);
		filterQuery.setParameter("ptype", type);
		List<Title> filteredResult = filterQuery.getResultList();
		return filteredResult;
	}

	// Find all title based on year
	@Override
	public List<Title> filterByYear(String year) {
		TypedQuery<Title> filterQuery = em.createNamedQuery("Title.filterByYear", Title.class);
		filterQuery.setParameter("pyear", year);
		List<Title> filteredResult = filterQuery.getResultList();
		return filteredResult;
	}

	// Sort Titles based on year
	@Override
	public List<Title> sortByYear() {
		TypedQuery<Title> sortedQuery = em.createNamedQuery("Title.sortByYear", Title.class);
		List<Title> sortedTitleList = sortedQuery.getResultList();
		return sortedTitleList;
	}

	// sort titles based on imdb Ratings
	@Override
	public List<Title> sortByImdbRating() {
		TypedQuery<Title> sortedQuery = em.createNamedQuery("Title.sortByImdbRating", Title.class);
		List<Title> sortedTitleList = sortedQuery.getResultList();
		return sortedTitleList;
	}

	// sort titles based on imdb Votes
	@Override
	public List<Title> sortByImdbVotes() {
		TypedQuery<Title> sortedQuery = em.createNamedQuery("Title.sortByImdbVotes", Title.class);
		List<Title> sortedTitleList = sortedQuery.getResultList();
		return sortedTitleList;
	}

	// Find all the top rate movies whose imdb Rating is >= 9
	@Override
	public List<Title> topRatedMovies() {
		TypedQuery<Title> ratedQuery = em.createNamedQuery("Title.topRatedMovies", Title.class);
		List<Title> ratedTitleList = ratedQuery.getResultList();
		return ratedTitleList;
	}

	// Find all the top rate series whose imdb Rating is >= 9
	@Override
	public List<Title> topRatedSeries() {
		TypedQuery<Title> ratedQuery = em.createNamedQuery("Title.topRatedSeries", Title.class);
		List<Title> ratedTitleList = ratedQuery.getResultList();
		return ratedTitleList;
	}

	// Find all the details of a title present in database
	@Override
	public Title viewTitleDetails(String id) {
		Title existingTitle = em.find(Title.class, id);
		return existingTitle;
	}

	// Filter catalog based on year and type - front end use only
	@Override
	public List<Title> filterByYear(String year, String type) {
		TypedQuery<Title> filterQuery = em.createNamedQuery("Title.filterByYearType", Title.class);
		filterQuery.setParameter("pyear", year);
		filterQuery.setParameter("ptype", type);
		List<Title> filteredResult = filterQuery.getResultList();
		return filteredResult;
	}

	@Override
	// Create a title - admin functionality
	public Title createTitle(Title title) {
		Title newTitle = commonFunctionality(title);
		em.persist(newTitle);
		return newTitle;
	}

	private Title commonFunctionality(Title title) {
		if(title.getGenre().isEmpty()){
			return title;
		}
		else{
		List<Genre> newGenre = title.getGenre();
		// Checks the genre is existing, if not the new genre is persisted
		List<Genre> existingGnereLsit = checkGenre(newGenre);
		title.setGenre(null);
		title.setGenre(existingGnereLsit);
		return title;
		}
	}

	// Update a Title - Admin functionality
	@Override
	public Title updateTitle(Title title) {
		Title newTitle = commonFunctionality(title);
		em.merge(newTitle);
		return newTitle;
	}

	// Checks the Genre present in the database if not persists the same returns
	// the genre list object
	private List<Genre> checkGenre(List<Genre> newGenre) {
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

	// To delete a Title - admin functionality
	@Override
	public void deleteTitle(String movieId) {
		Title existingTitle = viewTitleDetails(movieId);
		em.remove(existingTitle);

	}

	@Override
	public List<Title> filterByYearModified(String basedOn, String value) {
		// TODO Auto-generated method stub
		if(basedOn.contains("genre")){
			System.out.println("repo "+basedOn+" "+value);
			System.out.println("kjsdabkas"+basedOn+"jksdbkjas"+value);
			TypedQuery<Title> filteredQuery = em.createQuery("select t from Title t join t.genre g where g.genre = :pgenre",Title.class);
			filteredQuery.setParameter("pgenre", value);
			List<Title> filteredList = filteredQuery.getResultList();
			return filteredList;
		}
		
		TypedQuery<Title> filteredQuery = em.createQuery("select t from Title t where t."+basedOn+" = :pvalue",Title.class);
		filteredQuery.setParameter("pvalue", value);
		List<Title> filteredList = filteredQuery.getResultList();
		return filteredList;
		
	}

	@Override
	public List<String> yearList() {
		// TODO Auto-generated method stub
		TypedQuery<String> yearQuery = em.createQuery("select distinct(t.year) from Title t order by t.year desc",String.class);
		List<String> yearList = yearQuery.getResultList();
		return yearList;
	}

	@Override
	public List<String> typeList() {
		// TODO Auto-generated method stub
		TypedQuery<String> typeQuery = em.createQuery("select distinct(t.type) from Title t",String.class);
		List<String> typeList = typeQuery.getResultList();
		return typeList;
	}

}
