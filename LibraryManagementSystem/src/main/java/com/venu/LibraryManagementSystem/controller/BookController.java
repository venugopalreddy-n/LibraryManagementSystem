package com.venu.LibraryManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venu.LibraryManagementSystem.Requests.BookCreateRequest;
import com.venu.LibraryManagementSystem.enums.BookFilterType;
import com.venu.LibraryManagementSystem.exceptions.InvalidIdException;
import com.venu.LibraryManagementSystem.models.Book;
import com.venu.LibraryManagementSystem.response.BookSearchResponse;
import com.venu.LibraryManagementSystem.service.BookServiceInterf;

@RestController
public class BookController {
	
	@Autowired
	BookServiceInterf bookServiceInterf;
	@PostMapping("/saveBook")
	public ResponseEntity saveBook(@Valid @RequestBody BookCreateRequest bookCreateRequest)
	{
	 	bookServiceInterf.create(bookCreateRequest);
	 	return new ResponseEntity(HttpStatus.CREATED);
	}
	@GetMapping("/book")
	public Book findBook(@RequestParam("id") int bookId)
	{
		return bookServiceInterf.findById(bookId);
	}
	@GetMapping("/books/search")
	public List<BookSearchResponse>findBooks(@RequestParam("filter")BookFilterType bookFilterType,
			@RequestParam("value")String value)
	{
		return bookServiceInterf.findFilteredBooks(bookFilterType, value);
	}
	@DeleteMapping("/deleteBook")
	void deleteBookById(@RequestParam("id") int id)throws InvalidIdException
	{
		bookServiceInterf.deleteById(id);
	}
	

}
