package com.codingdojo.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.exam.models.Listing;
import com.codingdojo.exam.models.User;
import com.codingdojo.exam.repositories.ListingRepo;

@Service
public class ListingService {
	
	

	private final ListingRepo listingRepo;
	
	public ListingService(ListingRepo listingRepo) {
		this.listingRepo = listingRepo;
	}
	
	public List<Listing> allListings(){
		return listingRepo.findAll();
	}
	
	public Listing updateListing(Listing listing) {
		return listingRepo.save(listing);
	}
	
	public List<Listing> getAssignedUsers(User user){
		return listingRepo.findAllByUsers(user);
	}
	
	public List<Listing> getUnassignedUsers(User user){
		return listingRepo.findByUsersNotContains(user);
	}
	
	public Listing addListing(Listing listing) {
		return listingRepo.save(listing);
	}
	
	public void deleteListing(Listing listing) {
		listingRepo.delete(listing);
	}
	
	
	
	public Listing findById(Long id) {
		Optional<Listing> optionalListing = listingRepo.findByIdIs(id);
		if(optionalListing.isPresent()) {
			return optionalListing.get();
		}else {
			return null;
		}
	}
}
