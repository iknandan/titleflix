package io.titleflix.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;


@Data
@Entity
@Table
public class Title {
	
	@Id
	@GenericGenerator(name="myuuid",strategy="uuid2")
	@GeneratedValue(generator="myuuid")
	private String movieId;
	private String title;
	private String year;
	private double averageRating;
	private String rated;
	private String released;
	private String runtime;
	private String director;
	private String writers;
	private String actors;
	@Column(length=5000)
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private String metascore;
	private String imdbRating;
	private String imdbVotes;
	private String imdbID;
	private String type;
}
