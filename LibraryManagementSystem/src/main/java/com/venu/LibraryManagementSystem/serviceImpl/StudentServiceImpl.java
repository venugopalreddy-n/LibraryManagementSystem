package com.venu.LibraryManagementSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venu.LibraryManagementSystem.Repository.BookRepositoryInterf;
import com.venu.LibraryManagementSystem.Repository.StudentRepositoryInterf;
import com.venu.LibraryManagementSystem.Requests.StudentCreateRequest;
import com.venu.LibraryManagementSystem.enums.AccountStatus;
import com.venu.LibraryManagementSystem.models.Book;
import com.venu.LibraryManagementSystem.models.Student;
import com.venu.LibraryManagementSystem.service.StudentServiceInterf;


@Service
public class StudentServiceImpl implements StudentServiceInterf {
    
	@Autowired
	StudentRepositoryInterf studentRepositoryInterf;
	@Autowired
	BookRepositoryInterf bookRepositoryInterf;

	@Override
	public Student save(StudentCreateRequest studentCreateRequest) {
		// TODO Auto-generated method stub
		return saveFromStudent(studentCreateRequest.toStudent());
		
	}

	@Override
	public Student saveFromStudent(Student student) {
      
		return studentRepositoryInterf.save(student);
	}

	@Override
	public Student findById(int studentId) {
		return studentRepositoryInterf.findById(studentId).get();
	}

	@Override
	public void deleteById(int studentId) {
		// TODO Auto-generated method stub
		Student student=studentRepositoryInterf.findById(studentId).get();
		List<Book> bookList=student.getBookList();
	     for(Book b:bookList)
	    	 b.setStudent(null);
	     student.setBookList(null);
	    student.setAccountStatus(AccountStatus.INACTIVE);
	    studentRepositoryInterf.save(student);
		
	}

}
