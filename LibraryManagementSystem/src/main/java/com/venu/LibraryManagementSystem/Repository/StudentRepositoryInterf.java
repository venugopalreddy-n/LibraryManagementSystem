package com.venu.LibraryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venu.LibraryManagementSystem.models.Book;
import com.venu.LibraryManagementSystem.models.Student;

public interface StudentRepositoryInterf extends JpaRepository<Student,Integer>{

	
}
