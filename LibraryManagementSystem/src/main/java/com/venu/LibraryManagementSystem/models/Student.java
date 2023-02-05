package com.venu.LibraryManagementSystem.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.venu.LibraryManagementSystem.enums.AccountStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String name;
  private String email;
  @Column(unique=true)
  private String contact;
  @Enumerated(value=EnumType.STRING)
  private AccountStatus accountStatus;
  private String address;
  @CreationTimestamp
  private Date createdOn;
  @UpdateTimestamp
  private Date updatedOn;
  @OneToMany(mappedBy="student",fetch=FetchType.LAZY)
  private List<Book> bookList;
  @OneToMany(mappedBy="student",fetch=FetchType.LAZY)
  private List<Transaction> transactionList;
  
}
