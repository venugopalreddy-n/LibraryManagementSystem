package com.venu.LibraryManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venu.LibraryManagementSystem.exceptions.TransactionServiceException;
import com.venu.LibraryManagementSystem.service.TransactionServiceInterf;

@RestController
public class TransactionController {
 
	@Autowired
	TransactionServiceInterf transactionServiceInterf;
	
	@PostMapping("/transaction/issue")
	public ResponseEntity issuetxn(@RequestParam("studentId") int studentId,
			@RequestParam("bookId") int bookId)throws TransactionServiceException
	{
		
		return new ResponseEntity(transactionServiceInterf.issueTxn(studentId, bookId),HttpStatus.OK);
	}
	
	@PostMapping("/transaction/return")
	public ResponseEntity returntxn(@RequestParam("studentId")int studentId,
			@RequestParam("bookId") int bookId)throws TransactionServiceException
	{
		return new ResponseEntity(transactionServiceInterf.returntxn(studentId, bookId),HttpStatus.OK);
	}
}
