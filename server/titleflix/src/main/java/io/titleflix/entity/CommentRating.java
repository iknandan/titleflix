package io.titleflix.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
/**
 * Comment and Rating Entity
 * @author nandan
 *
 */
@Table
@Entity
@Data
@NamedQueries({@NamedQuery(name="Rating.averageQuery",query="SELECT AVG(r.rating) FROM CommentRating r WHERE movieId_movieId = :pmovieId"),
	@NamedQuery(name="Comment.findAll",query="select r from CommentRating r"),
@NamedQuery(name="Reviews.ofTitle",query="select r from CommentRating r where movieId_movieId = :pmovieId")})
public class CommentRating {

	@Id
	@GenericGenerator(name="myuuid",strategy="uuid2")
	@GeneratedValue(generator="myuuid")
	private String commonId;
	@Column(length=5000)
	private String comment;
	private int rating;
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch=FetchType.EAGER)
	private User userId;
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE},fetch=FetchType.EAGER)
	private Title movieId;
	
	
}
