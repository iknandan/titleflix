package io.titleflix.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Table
@Entity
@Data
public class User {
	
	@Id
	@GenericGenerator(name="myuuid",strategy="uuid2")
	@GeneratedValue(generator="myuuid")
	private String id;
	private String userName;
	@Column(unique=true)
	private String email;
	private String password;
	private String role;
	
}
