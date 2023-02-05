package com.venu.LibraryManagementSystem.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.venu.LibraryManagementSystem.enums.Genre;
import com.venu.LibraryManagementSystem.response.BookSearchResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int cost;
	private String isbn;
	@Enumerated(value=EnumType.STRING)
	private Genre genre;
    @ManyToOne
    @JoinColumn
    private Student student;
    @ManyToOne
    @JsonIgnoreProperties({"bookList"})
    private Author author;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;
    @OneToMany(mappedBy="book",fetch=FetchType.LAZY)
    private List<Transaction> transactionList;
    public BookSearchResponse to()
    {
    	return BookSearchResponse.builder()
    			.author(author)
    			.cost(cost)
    			.isbn(isbn)
    			.createdOn(createdOn)
    			.id(id)
    			.name(name)
    			.student(student)
    			.genre(genre)
    			.updatedOn(updatedOn)
    			.build();
    }
    
}
