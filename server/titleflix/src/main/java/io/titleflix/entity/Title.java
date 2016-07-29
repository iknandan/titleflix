package io.titleflix.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;


@Data
@Entity
@Table
@NamedQueries({@NamedQuery(name="Title.findAll",query="select t from Title t"),
	@NamedQuery(name="Title.filterByType",query="select t from Title t where t.type = :ptype "),
	@NamedQuery(name="Title.filterByYear",query="select t from Title t where t.year = :pyear"),
	@NamedQuery(name="Title.sortByYear",query="select t from Title t order by (t.year+0) desc"),
	@NamedQuery(name="Title.sortByImdbRating",query="select t from Title t order by (t.imdbRating+0) desc"),
	@NamedQuery(name="Title.sortByImdbVotes",query="select t from Title t order by (t.imdbVotes+0) desc"),
	@NamedQuery(name="Title.topRatedMovies",query="select t from Title t where t.imdbRating >= 9 and t.type = 'movie' order by (t.imdbRating+0) desc "),
	@NamedQuery(name="Title.topRatedSeries",query="select t from Title t where t.imdbRating >= 9 and t.type = 'series' order by (t.imdbRating+0) desc"),
	@NamedQuery(name="Title.filterByYearType",query="select t from Title t where t.year = :pyear and t.type = :ptype"),
})
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
	@ManyToMany(cascade={javax.persistence.CascadeType.DETACH,javax.persistence.CascadeType.MERGE,javax.persistence.CascadeType.PERSIST,javax.persistence.CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinTable(name="title_genre", joinColumns={@JoinColumn(name="movieId", referencedColumnName="movieId")},
	inverseJoinColumns={@JoinColumn(name="genreId", referencedColumnName="genreId")})
	private List<Genre> genre;
}
