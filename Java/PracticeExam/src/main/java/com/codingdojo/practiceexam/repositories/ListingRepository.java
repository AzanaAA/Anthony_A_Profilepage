package com.codingdojo.practiceexam.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.practiceexam.models.Listing;
import com.codingdojo.practiceexam.models.User;

@Repository
public interface ListingRepository extends CrudRepository<Listing,Long> {
	public List<Listing> findAll();
	Optional<Listing> findById(Long id);
	List<Listing> findAllByUser(User user);
	
	
	

}
