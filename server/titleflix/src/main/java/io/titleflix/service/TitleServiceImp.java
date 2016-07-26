package io.titleflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.titleflix.entity.Title;
import io.titleflix.exception.NoTitlesPresent;
import io.titleflix.repository.TitleRepository;

@Service
@Transactional
public class TitleServiceImp implements TitleService{

	@Autowired
	private TitleRepository titleRepository;
	@Override
	public List<Title> findAllTitles() throws NoTitlesPresent {
		// TODO Auto-generated method stub
		List<Title> existingTitles = titleRepository.findAllTitles();
		if(existingTitles != null){
			return existingTitles;
		}
		else{
			throw new NoTitlesPresent();
		}
		
	}

}
