package com.venu.LibraryManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venu.LibraryManagementSystem.models.Author;
import com.venu.LibraryManagementSystem.response.AuthorSearchResponse;
import com.venu.LibraryManagementSystem.service.AuthorServiceInterf;

@RestController
public class AuthorController {


	@Autowired
	AuthorServiceInterf authorServiceInterf;
	
	@GetMapping("/findByEmail")
	public AuthorSearchResponse findByEmail(@RequestParam("email")String email)
	{
		return authorServiceInterf.findAuthorResponseFromAuthor(email);
	}
    
}
