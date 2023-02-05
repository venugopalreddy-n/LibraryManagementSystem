package com.venu.LibraryManagementSystem.service;

import com.venu.LibraryManagementSystem.models.Author;
import com.venu.LibraryManagementSystem.response.AuthorSearchResponse;

public interface AuthorServiceInterf {

	Author createAuthor(Author author);
	Author findByEmail(String email);
	AuthorSearchResponse findAuthorResponseFromAuthor(String email);
}
