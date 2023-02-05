package com.venu.LibraryManagementSystem.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venu.LibraryManagementSystem.Repository.AuthorRepositoryInterf;
import com.venu.LibraryManagementSystem.models.Author;
import com.venu.LibraryManagementSystem.response.AuthorSearchResponse;
import com.venu.LibraryManagementSystem.service.AuthorServiceInterf;
@Service
public class AuthorServiceImpl implements AuthorServiceInterf {

	@Autowired
	AuthorRepositoryInterf authorRepositoryInterf;

	@Override
	public Author createAuthor(Author author) {
		// TODO Auto-generated method stub
		authorRepositoryInterf.save(author);
		
		return author;
	}
    @Override
	public AuthorSearchResponse findAuthorResponseFromAuthor (String email)
	{
		Author author= findByEmail(email);
		return AuthorSearchResponse.builder()
				.id(author.getId())
				.age(author.getAge())
				.name(author.getName())
				.email(author.getEmail())
				.country(author.getCountry())
				.createdOn(author.getCreatedOn())
				.updatedOn(author.getUpdatedOn())
				.bookList(author.getBookList())
				.build();
	}

    @Override
	public Author findByEmail(String email) {
		// TODO Auto-generated method stub
		return authorRepositoryInterf.findByEmail(email);
		//return null;
	}
	
	

}
