package com.venu.LibraryManagementSystem.Requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.NotBlank;

import com.venu.LibraryManagementSystem.enums.Genre;
import com.venu.LibraryManagementSystem.models.Author;
import com.venu.LibraryManagementSystem.models.Book;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookCreateRequest {

	@NotBlank
	private String name;
	@Positive
	private int cost;
	@NotBlank
	private String isbn;
	@NotNull
	private Genre genre;
	@NotNull
	private Author author;
	
	public Book  toBook()
	{
		return Book.builder()
				.cost(cost)
				.genre(genre)
				.name(name)
				.author(author)
				.isbn(isbn)
				.build();
				
	}
	
}
