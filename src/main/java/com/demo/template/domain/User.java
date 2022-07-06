package com.demo.template.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {

	@NotEmpty(message = "firstName may not be empty")
	@Size(min = 2, max = 50, message = "firstName must be between 2 and 50 characters long")
	private String firstName;
	@NotEmpty(message = "lastName may not be empty")
	@Size(min = 2, max = 50, message = "lastName must be between 2 and 50 characters long")
	private String lastName;

	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
