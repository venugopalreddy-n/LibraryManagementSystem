package com.venu.LibraryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venu.LibraryManagementSystem.enums.TransactionType;
import com.venu.LibraryManagementSystem.models.Book;
import com.venu.LibraryManagementSystem.models.Student;
import com.venu.LibraryManagementSystem.models.Transaction;

public interface TransactionRepositoryInterf extends JpaRepository<Transaction,Integer> {

	Transaction findTopByBookAndStudentAndTransactionTypeOrderById(Book book,Student student,TransactionType
			issue);
	
}
