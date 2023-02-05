package com.venu.LibraryManagementSystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venu.LibraryManagementSystem.Repository.BookRepositoryInterf;
import com.venu.LibraryManagementSystem.Repository.TransactionRepositoryInterf;
import com.venu.LibraryManagementSystem.Requests.BookCreateRequest;
import com.venu.LibraryManagementSystem.enums.BookFilterType;
import com.venu.LibraryManagementSystem.enums.Genre;
import com.venu.LibraryManagementSystem.exceptions.InvalidIdException;
import com.venu.LibraryManagementSystem.models.Author;
import com.venu.LibraryManagementSystem.models.Book;
import com.venu.LibraryManagementSystem.response.BookSearchResponse;
import com.venu.LibraryManagementSystem.service.AuthorServiceInterf;
import com.venu.LibraryManagementSystem.service.BookServiceInterf;
import com.venu.LibraryManagementSystem.service.TransactionServiceInterf;
@Service
public class BookServiceImpl implements BookServiceInterf {

	@Autowired
	BookRepositoryInterf bookRepositoryInterf;
	@Autowired
	AuthorServiceInterf authorServiceInterf;
	@Autowired
	TransactionRepositoryInterf transactionRepositoryInterf;
	@Override
	public Book create(BookCreateRequest bookCreateRequest) {
		// TODO Auto-generated method stub
		Book book=bookCreateRequest.toBook();
		Author author=book.getAuthor();
		Author authorFromDb=authorServiceInterf.findByEmail(author.getEmail());
		if(authorFromDb==null)
		 authorFromDb=authorServiceInterf.createAuthor(book.getAuthor());
		book.setAuthor(authorFromDb);
		return bookRepositoryInterf.save(book);
		
	
	}

	@Override
	public Book save(Book book) {
		
		return bookRepositoryInterf.save(book);
	}

	@Override
	public Book findById(Integer id) {
		
		return bookRepositoryInterf.findById(id).get();
	}
   @Override
	public  List<BookSearchResponse> findFilteredBooks(BookFilterType bookFilterType,String value)
	{
		return findBooks(bookFilterType,value).stream()
				.map(Book->Book.to())
				.collect(Collectors.toList());
	}

	public List<Book> findBooks(BookFilterType bookFilterType, String value) {
		switch(bookFilterType)
		{
		case NAME:
		   return bookRepositoryInterf.findByName(value);
		case GENRE:
			return bookRepositoryInterf.findByGenre(Genre.valueOf(value));
		case AUTHOR_NAME:
			return bookRepositoryInterf.findByAuthorName(value);
		case COST:
			return bookRepositoryInterf.findByCost(Integer.parseInt(value));
		case ID:
			return bookRepositoryInterf.findAllById(new ArrayList<Integer>(Integer.parseInt(value)));
		}
		
		return null;
	}

	@Override
	public void deleteById(int id) throws InvalidIdException {
		// TODO Auto-generated method stub
	
		Book book=bookRepositoryInterf.findById(id).get();
		if(book==null)
			throw new InvalidIdException("Book with given id is not exist");
	    book.setStudent(null);
	   
	   // bookRepositoryInterf.save(book);
		bookRepositoryInterf.deleteById(id);
		
	}

}
