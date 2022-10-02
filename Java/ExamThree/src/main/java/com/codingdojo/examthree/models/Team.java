package com.codingdojo.examthree.models;

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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="teams")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message="Team Name Must Not Be Blank!")
	private String teamName;
	
	@NotNull(message="Skill Level Required 1-5!")
	@Min(1)
	@Max(5)
	private Integer skillLevel;
	
	@NotBlank(message="Game Day Must Not Be Blank!")
	private String gameDay;
	
	
	 public Team(String teamName, Integer skillLevel, String gameDay) {
	    	this.teamName = teamName;
	    	this.skillLevel = skillLevel;
	    	this.gameDay= gameDay;
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
    
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name="users_teams",
    		joinColumns = @JoinColumn(name = "team_id"),
    		inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User>users;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    public User getUser() {
		return user;
	}
    
    
    public Team() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Integer getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(Integer skillLevel) {
		this.skillLevel = skillLevel;
	}
	public String getGameDay() {
		return gameDay;
	}
	public void setGameDay(String gameDay) {
		this.gameDay = gameDay;
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	

}
