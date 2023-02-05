package com.venu.LibraryManagementSystem.Requests;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.venu.LibraryManagementSystem.enums.AccountStatus;
import com.venu.LibraryManagementSystem.models.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StudentCreateRequest {

	@NotBlank
	private String name;
	@Column(unique=true)
	private String email;
	@NotBlank
	private String contact;
	private String address;
	public Student toStudent()
	{
		return Student.builder()
				.address(address)
				.name(name)
				.contact(contact)
				.email(email)
				.accountStatus(AccountStatus.ACTIVE)
				.build();
	}
}
