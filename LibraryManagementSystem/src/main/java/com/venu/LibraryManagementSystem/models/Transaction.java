package com.venu.LibraryManagementSystem.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.venu.LibraryManagementSystem.enums.AccountStatus;
import com.venu.LibraryManagementSystem.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String externalId;
    @Enumerated(value=EnumType.STRING)
    private TransactionType transactionType;
    private double payment;
    @ManyToOne
    @JsonIgnoreProperties("transactionList")
    private Book book;
    @ManyToOne
    private Student student;
    @CreationTimestamp
    private Date createdOn;
   
}
