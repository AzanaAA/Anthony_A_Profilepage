package com.codingdojo.practiceexam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Username is required!")
	@Size(min=3, message="Username must be at least 3 characters")
	private String userName;
	
	@NotEmpty
	@Email(message="Please enter a valid email!")
	private String email;
	
	@NotEmpty(message="Password is required!")
	@Size(min=8, message="Password must be at least 8 characters long!")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirm Password is required!")
	@Size(min=8, message="Password must be at least 8 characters long!")
	private String confirm;
	
	

	public List<Listing> getListings() {
		return listings;
	}
	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}


	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    
    @Column(updatable=false)
    @OneToMany(mappedBy="user",fetch = FetchType.LAZY)
	private List<Listing> listings;
    
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    		name= "users_listings",
    		joinColumns=@JoinColumn(name="user_id"),
    		inverseJoinColumns = @JoinColumn(name="listing_id")
    		)
    private List<Listing> listing;
    
    
	
	
	public List<Listing> getListing() {
		return listing;
	}
	public void setListing(List<Listing> listing) {
		this.listing = listing;
	}
	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
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
	
	
	
	
	

}
