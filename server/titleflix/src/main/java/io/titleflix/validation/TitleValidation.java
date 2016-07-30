package io.titleflix.validation;

import org.springframework.stereotype.Component;

import io.titleflix.entity.Title;
import io.titleflix.exception.TitleFieldValidation;
/**
 * This is a Title validation class with validats all the Title inputs
 * @author nandan
 *
 */
@Component
public class TitleValidation {

	public Title validateTitle(Title title) throws TitleFieldValidation {
		if (title.getActors() == null || title.getActors() == "") {
			throw new TitleFieldValidation();
		} else if (title.getAwards() == null || title.getAwards() == "") {
			throw new TitleFieldValidation();
		} else if (title.getCountry() == null || title.getCountry() == "") {
			throw new TitleFieldValidation();
		} else if (title.getDirector() == null || title.getDirector() == "") {
			throw new TitleFieldValidation();
		} else if (title.getImdbID() == null || title.getImdbID() == "") {
			throw new TitleFieldValidation();
		} else if (title.getImdbRating() == null || title.getImdbRating() == "") {
			throw new TitleFieldValidation();
		} else if (title.getImdbVotes() == null || title.getImdbVotes() == "") {
			throw new TitleFieldValidation();
		} else if (title.getLanguage() == null || title.getLanguage() == "") {
			throw new TitleFieldValidation();
		} else if (title.getMetascore() == null || title.getMetascore() == "") {
			throw new TitleFieldValidation();
		} else if (title.getPlot() == null || title.getPlot() == "") {
			throw new TitleFieldValidation();
		} else if (title.getPoster() == null || title.getPoster() == "") {
			throw new TitleFieldValidation();
		} else if (title.getRated() == null || title.getRated() == "") {
			throw new TitleFieldValidation();
		} else if (title.getReleased() == null || title.getReleased() == "") {
			throw new TitleFieldValidation();
		} else if (title.getRuntime() == null || title.getRuntime() == "") {
			throw new TitleFieldValidation();
		} else if (title.getTitle() == null || title.getTitle() == "") {
			throw new TitleFieldValidation();
		} else if (title.getType() == null || title.getType() == "") {
			throw new TitleFieldValidation();
		} else if (title.getWriters() == null || title.getWriters() == "") {
			throw new TitleFieldValidation();
		} else if (title.getYear() == null || title.getYear() == "") {
			throw new TitleFieldValidation();
		}
		return title;
	}

}
