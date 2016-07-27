package io.titleflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceProperty;
import javax.persistence.TypedQuery;

import org.hibernate.cfg.Environment;
import org.springframework.stereotype.Repository;

import io.titleflix.entity.Genre;
import io.titleflix.entity.Title;

@Repository
public class GenreRepositoryImp implements GenreRepository {

	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Title> filterByGenre(String genreId) {
		// TODO Auto-generated method stub
		TypedQuery<Title> genreQuery = em.createQuery("select t from Title t join t.genre g where g.genre = :pgenreId ",Title.class);
		genreQuery.setParameter("pgenreId", genreId);
		List<Title> titleList = genreQuery.getResultList();
		return titleList;
	}
	@Override
	public List<Genre> viewAllGenre() {
		// TODO Auto-generated method stub
		TypedQuery<Genre> genreListQuery = em.createQuery("select g from Genre g",Genre.class);
		List<Genre> genreList = genreListQuery.getResultList();
		return genreList;
	}

	

}