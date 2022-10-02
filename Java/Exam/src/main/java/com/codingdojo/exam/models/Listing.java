package com.codingdojo.exam.models;

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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="listings")
public class Listing {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Address is required!")
    private String address;
    
    @NotBlank(message="Listed on is required!")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date listedOn;
    
    @NotBlank(message="Added By is required!")
    private String addedBy;
    
    @NotNull
    @Min(1)
    private int price;
    
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="listing_id")
    private User lead;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "users_listings",
			joinColumns = @JoinColumn(name = "listing_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
    private List<User> users;

	
    
    
    public Listing() {}
    
    public Listing(String address, Date listedOn, String addedBy, Integer price, User lead) {
    	this.address = address;
    	this.listedOn = listedOn;
    	this.addedBy = addedBy;
    	this.price = price;
    	this.lead = lead;
    }
	public Long getId() {
		return id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getListedOn() {
		return listedOn;
	}
	public void setListedOn(Date listedOn) {
		this.listedOn = listedOn;
	}
	public String getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
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
	public User getLead() {
		return lead;
	}
	public void setLead(User lead) {
		this.lead = lead;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
