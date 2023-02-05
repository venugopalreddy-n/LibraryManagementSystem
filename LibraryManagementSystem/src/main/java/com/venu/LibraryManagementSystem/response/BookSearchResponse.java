package com.venu.LibraryManagementSystem.response;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.venu.LibraryManagementSystem.enums.Genre;
import com.venu.LibraryManagementSystem.models.Author;
import com.venu.LibraryManagementSystem.models.Student;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookSearchResponse {
   private int id;
   private String name;
   private int cost;
   private String isbn ;
   private Student student;
   private Genre genre;
   @JsonIgnoreProperties({"bookList"})
   private Author author;
   @CreationTimestamp
   private Date createdOn;
   @UpdateTimestamp
   private Date updatedOn;
   
  
}
