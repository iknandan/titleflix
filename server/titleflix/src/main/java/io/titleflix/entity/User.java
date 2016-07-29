package io.titleflix.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Table
@Entity
@Data
@NamedQueries({@NamedQuery(name="User.findByEmail",query="select u from User u where u.email =:pemail"),
	@NamedQuery(name="User.signIn",query="select u from User u where u.email = :pemail and u.password = :ppassword"),
	@NamedQuery(name="User.findAll",query="select u from User u")
})
public class User {
	
	@Id
	@GenericGenerator(name="myuuid",strategy="uuid2")
	@GeneratedValue(generator="myuuid")
	private String Id;	
	private String userName;
	@Column(unique=true)	
	private String email;
	private String password;
	private String role;
	
}
