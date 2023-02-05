package com.venu.LibraryManagementSystem.serviceImpl;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venu.LibraryManagementSystem.Repository.TransactionRepositoryInterf;
import com.venu.LibraryManagementSystem.enums.AccountStatus;
import com.venu.LibraryManagementSystem.enums.TransactionType;
import com.venu.LibraryManagementSystem.exceptions.TransactionServiceException;
import com.venu.LibraryManagementSystem.models.Book;
import com.venu.LibraryManagementSystem.models.Student;
import com.venu.LibraryManagementSystem.models.Transaction;
import com.venu.LibraryManagementSystem.service.BookServiceInterf;
import com.venu.LibraryManagementSystem.service.StudentServiceInterf;
import com.venu.LibraryManagementSystem.service.TransactionServiceInterf;

@Service
public class TransactionServiceImpl implements TransactionServiceInterf {
  
	@Autowired
	BookServiceInterf bookServiceInterf;
	@Autowired
	StudentServiceInterf studentServiceInterf;
	@Autowired
	TransactionRepositoryInterf transactionRepositoryInterf;
	
	int max_days_allowed=15;
	@Override
	public String issueTxn(int studentId, int bookId) throws TransactionServiceException {
		//check if studentId is valid
		//Check if Book is present and also available
		//made Transaction
		//Make the Book Unavailable
		Student student=studentServiceInterf.findById(studentId);
		Book book=bookServiceInterf.findById(bookId);
		if(student==null || student.getAccountStatus()==AccountStatus.INACTIVE )
			throw new TransactionServiceException("The given Student is not present");
		if(book==null || book.getStudent()!=null)
			throw new TransactionServiceException("The given book is unavailable");
		Transaction transaction= Transaction.builder()
				               .student(student)
				               .book(book)
				               .payment(0)
				               .transactionType(TransactionType.ISSUE)
				               .externalId(UUID.randomUUID().toString())
                               .build();
		transactionRepositoryInterf.save(transaction);
		book.setStudent(student);
		bookServiceInterf.save(book);
		return transaction.getExternalId();
	}

	@Override
	public String returntxn(int studentId, int bookId) throws TransactionServiceException {
		
		Student student=studentServiceInterf.findById(studentId);
		Book book =bookServiceInterf.findById(bookId);
		if(student==null )
			throw new TransactionServiceException("the given student is not availble");
		if(book==null)
			throw new TransactionServiceException("the given book not exist in library");
		if(book.getStudent()==null || book.getStudent().getId()!=studentId)
			throw new TransactionServiceException("The given Student not exist");
		Transaction issuetxn=transactionRepositoryInterf.findTopByBookAndStudentAndTransactionTypeOrderById(book, student,TransactionType.ISSUE);
		Transaction transaction =Transaction.builder()
				                .book(book)
				                .student(student)
				                .transactionType(TransactionType.RETURN)
				                .externalId(UUID.randomUUID().toString())
				                .payment(calculatePayment(issuetxn))
				                .build();
		transactionRepositoryInterf.save(transaction);
		book.setStudent(null);
		bookServiceInterf.save(book);
		return transaction.getExternalId();
				                
	}
	public double calculatePayment(Transaction transaction)
	{
		long issueTime= transaction.getCreatedOn().getTime();
		long currentTime=System.currentTimeMillis();
		long diff= currentTime-issueTime;
		long daysPassed=TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
		if(daysPassed>max_days_allowed)
			return (daysPassed-max_days_allowed)*10.0;
		return 0.0;
		
	}

	
	

}
