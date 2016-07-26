package io.titleflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.titleflix.entity.Title;

@Repository
public class TitleRepositoryImp implements TitleRepository{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Title> findAllTitles() {
		// TODO Auto-generated method stub
		TypedQuery<Title> titleQuery = em.createQuery("select t from Title t",Title.class);
		List<Title> titleList = titleQuery.getResultList();
		if(titleList.isEmpty()){
			return null;
		}
		else{
			return titleList;
		}
		
	}

}
