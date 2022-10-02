package com.codingdojo.exam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.exam.models.Listing;
import com.codingdojo.exam.models.User;

@Repository
public interface ListingRepo extends CrudRepository<Listing, Long> {

	List<Listing> findAll();
	Listing findByIdIs(Long id);
	List<Listing> findAllByUsers(User user);
	List<Listing> findByUsersNotContains(User user);
}

