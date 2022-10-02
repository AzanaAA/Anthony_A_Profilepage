package com.codingdojo.houseHunter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.houseHunter.models.Listing;
import com.codingdojo.houseHunter.models.User;
import com.codingdojo.houseHunter.repositories.ListingRepository;

@Service
public class ListingService {
	
	
	private final ListingRepository listingRepository;
	
	public ListingService(ListingRepository listingRepository) {
		this.listingRepository = listingRepository;
	}

	public List<Listing> allListings(){
		return listingRepository.findAll();
	}
	
	public Listing updateListing(Listing listing) {
		return listingRepository.save(listing);
	}
	
	public List<Listing> getAssignedUsers(User user){
		return listingRepository.findAllByUsers(user);
	}
	
	public List<Listing> getUnassignedUsers(User user){
		return listingRepository.findByUsersNotContains(user);
	}


	
	public Listing addListing(Listing listing) {
		return listingRepository.save(listing);
	}
	
	public void deleteListing(Listing listing) {
		listingRepository.delete(listing);
	}
	
	public Listing findById(Long id) {
		Optional<Listing> optionalListing = listingRepository.findById(id);
		if(optionalListing.isPresent()) {
			return optionalListing.get();
		}else {
			return null;
		}
	}
	
	
}
