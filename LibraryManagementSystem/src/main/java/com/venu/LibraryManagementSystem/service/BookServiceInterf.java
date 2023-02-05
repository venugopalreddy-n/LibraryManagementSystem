package com.venu.LibraryManagementSystem.service;

import java.util.List;

import com.venu.LibraryManagementSystem.Requests.BookCreateRequest;
import com.venu.LibraryManagementSystem.enums.BookFilterType;
import com.venu.LibraryManagementSystem.exceptions.InvalidIdException;
import com.venu.LibraryManagementSystem.models.Book;
import com.venu.LibraryManagementSystem.response.BookSearchResponse;

public interface BookServiceInterf {

	Book create(BookCreateRequest bookCreateRequest);
	Book save(Book book);
	Book findById(Integer id);
	
	List<BookSearchResponse>findFilteredBooks(BookFilterType bookFilterType,String value);
    void deleteById(int id)throws InvalidIdException;	
}
