package com.codingdojo.houseHunter.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.houseHunter.models.Listing;
import com.codingdojo.houseHunter.models.User;

@Repository
public interface ListingRepository extends CrudRepository<Listing,Long> {
	List<Listing> findAll ();
	Listing findByIdIs(Long id);
	List<Listing> findAllByUsers(User user);
	List<Listing> findByUsersNotContains(User user);

}
