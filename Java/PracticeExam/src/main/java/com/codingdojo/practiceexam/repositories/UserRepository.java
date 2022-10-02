package com.codingdojo.practiceexam.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.practiceexam.models.Listing;
import com.codingdojo.practiceexam.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	Optional<User> findByEmail (String email);
	User findByIdIs(Long id);
	List<User> findAll();
	List<User> findAllByListings (Listing listing);
	
	
	
	
}
