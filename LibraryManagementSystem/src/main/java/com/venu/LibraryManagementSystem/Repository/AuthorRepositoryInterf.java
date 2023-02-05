package com.venu.LibraryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venu.LibraryManagementSystem.models.Author;

public interface AuthorRepositoryInterf extends JpaRepository<Author,Integer> {
  Author findByEmail(String email);
}
