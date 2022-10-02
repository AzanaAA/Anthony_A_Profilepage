package com.codingdojo.bookclub.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name = "users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	
	
    @NotEmpty(message="A Username Is Required!")
    @Size(min=3, max=20, message="Username must be between 3 and 20 characters")
    private String userName;
    
    @NotEmpty(message="A Email-Address Is Required!")
    @Email(message="Please Enter A Valid Email-Address!")
    private String email;
    
    @NotEmpty(message="A Password Is Required!")
    @Size(min=8, message="Password must be between 8 and 20 Characters Long!")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password Is Required!")
    @Size(min=8, message="Confirm Password Must Be Between 8 And 20 Characters Long, And Match!")
    private String confirm;
	
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
    
    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Book> books;
	
    
	public User() {}
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    
    
    
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
    

	public Long getId() {
		return id;
	}
	
	
	

	public void setId(Long id) {
		this.id = id;
	}
	
	

	
	public String getConfirm() {
		return confirm;
	}

	
	
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	
	
	
	public String getUserName() {
		return userName;
	}

	
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	
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

	
	
	public Date getCreatedAt() {
		return createdAt;
	}

	
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	
	public List<Book> getBooks() {
		return books;
	}

	
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
