package com.codingdojo.bookclub.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserLogin {
	
	@NotEmpty(message="A Email-Address Is Required!")
    @Email(message="Please Enter A Valid Email-Address!")
    private String email;
    
    @NotEmpty(message="A Password Is Required!")
    private String password;
    
    public UserLogin() {}
    
    public String getEmail() {
		return email;
	}

    
    
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public String getPassword() {
		return password;
	}

	
	
	public void setPassword(String password) {
		this.password = password;
	}

}
