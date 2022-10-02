package com.codingdojo.examthree.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.examthree.models.Team;
import com.codingdojo.examthree.models.User;
import com.codingdojo.examthree.repositories.TeamRepository;

@Service
public class TeamService {
	private final TeamRepository teamRepo;
	
	public TeamService(TeamRepository teamRepo) {
		this.teamRepo = teamRepo;
	}
	
	public List<Team> allTeams(){
		return teamRepo.findAll();
	}
	
	public Team updateTeam(Team team) {
		return teamRepo.save(team);
	}
	
	public List<Team> getTeamUsers (User user){
		return teamRepo.findAllByUser(user);
	}
	
	public Team addTeam (Team team) {
		return teamRepo.save(team);
	}
	
	public void deleteTeam(Team team) {
		teamRepo.delete(team);
	}
	
	public Team findById(Long id) {
		Optional<Team> optionalTeam = teamRepo.findById(id);
		if(optionalTeam.isPresent()){
			return optionalTeam.get();
		}
		else {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}


