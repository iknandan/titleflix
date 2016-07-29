package io.titleflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table
@NamedQueries({@NamedQuery(name="Genre.filterByGenre",query="select t from Title t join t.genre g where g.genre = :pgenreId"),
	@NamedQuery(name="Gnere.viewAllGenre",query="select g from Genre g")
})
public class Genre {

	@Id
	@GenericGenerator(name="myuuid",strategy="uuid2")
	@GeneratedValue(generator="myuuid")
	private String genreId;
	private String genre;
}
