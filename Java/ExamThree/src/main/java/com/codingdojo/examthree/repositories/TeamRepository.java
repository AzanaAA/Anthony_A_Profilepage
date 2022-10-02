package com.codingdojo.examthree.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.examthree.models.Team;
import com.codingdojo.examthree.models.User;

@Repository
public interface TeamRepository extends CrudRepository<Team,Long> {
	
	public List<Team> findAll();
	Optional<Team> findById(Long id);
	List<Team> findAllByUser(User user);
}
