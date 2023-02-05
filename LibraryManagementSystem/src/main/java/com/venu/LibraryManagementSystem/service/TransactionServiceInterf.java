package com.venu.LibraryManagementSystem.service;

import com.venu.LibraryManagementSystem.exceptions.InvalidIdException;
import com.venu.LibraryManagementSystem.exceptions.TransactionServiceException;
import com.venu.LibraryManagementSystem.models.Book;

public interface TransactionServiceInterf {

	String issueTxn(int studentId,int bookId)throws TransactionServiceException ;
	String returntxn(int studentId,int bookId)throws TransactionServiceException;
	
	
}
