package io.titleflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.titleflix.entity.Title;
import io.titleflix.exception.NoTitlesPresent;
import io.titleflix.service.TitleService;

@RestController
@RequestMapping(value="/title")
public class TitleController {

	@Autowired
	private TitleService titleService;
	
	
	//To view All Titles
	
	@RequestMapping(value="/viewAll",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> findAllTitles() throws NoTitlesPresent {
		
		List<Title> existing = titleService.findAllTitles();
		return existing;
	}
	
	
	
}
