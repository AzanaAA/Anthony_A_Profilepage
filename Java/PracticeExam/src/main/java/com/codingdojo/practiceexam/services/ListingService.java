package com.codingdojo.practiceexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.practiceexam.models.Listing;
import com.codingdojo.practiceexam.models.User;
import com.codingdojo.practiceexam.repositories.ListingRepository;

@Service
public class ListingService {
	private final ListingRepository listingRepo;
	
	public ListingService(ListingRepository listingRepo) {
		this.listingRepo = listingRepo;
	}

	public List<Listing> allListings(){
		return listingRepo.findAll();
	}
	
	
	
	public Listing updateListing(Listing listing) {
		return listingRepo.save(listing);
	}
	
	
	public List<Listing> getListingUsers(User user){
		return listingRepo.findAllByUser(user);
	}
	
	public Listing addListing(Listing listing) {
		return listingRepo.save(listing);
	}
	
	public void deleteListing(Listing listing) {
		listingRepo.delete(listing);
	}
	
	
	public Listing findById(Long id) {
		Optional<Listing> optionalListing = listingRepo.findById(id);
		if(optionalListing.isPresent()) {
			return optionalListing.get();
		}
		else {
			return null;
		}
	}
	
	
	
	
}
