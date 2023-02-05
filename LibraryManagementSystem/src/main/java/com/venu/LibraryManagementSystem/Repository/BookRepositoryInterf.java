package com.venu.LibraryManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venu.LibraryManagementSystem.enums.Genre;
import com.venu.LibraryManagementSystem.models.Book;

public interface BookRepositoryInterf extends JpaRepository<Book,Integer>{

	List<Book>findByName(String name);
	List<Book>findByAuthorName(String name);
	List<Book>findByGenre(Genre genre);
	List<Book>findByCost(int cost);
	Book findByStudentId(int studentId);
}
