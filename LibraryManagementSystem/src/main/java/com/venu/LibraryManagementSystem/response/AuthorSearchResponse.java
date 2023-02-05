package com.venu.LibraryManagementSystem.response;

import java.util.Date;
import java.util.List;

import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.venu.LibraryManagementSystem.models.Book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@AllArgsConstructor
@Builder
public class AuthorSearchResponse {

	private int id;
	private String name;
	private int age;
	private String  country;
	private String mobile;
	private String email;
	@CreationTimestamp
	private Date createdOn;
	@UpdateTimestamp
	private Date updatedOn;
	@OneToMany(mappedBy="author")
	@JsonIgnoreProperties({"author"})
	private List<Book> bookList;
}
