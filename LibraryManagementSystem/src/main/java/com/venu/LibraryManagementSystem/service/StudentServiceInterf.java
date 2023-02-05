package com.venu.LibraryManagementSystem.service;

import com.venu.LibraryManagementSystem.Requests.StudentCreateRequest;
import com.venu.LibraryManagementSystem.models.Student;

public interface StudentServiceInterf {
 Student save(StudentCreateRequest studentCreateRequest);
 Student saveFromStudent(Student student);
 Student findById(int studentId);
 void deleteById(int studentId);
}
