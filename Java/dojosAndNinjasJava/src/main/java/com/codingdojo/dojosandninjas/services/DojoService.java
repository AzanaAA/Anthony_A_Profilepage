package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	private final DojoRepository repository;
	
	public DojoService(DojoRepository repository) {
		this.repository = repository;
	}
	
	
	public Dojo create(Dojo dojo) {
    	System.out.println(dojo.getId());
        return repository.save(dojo);
	}
	
	public Dojo find(Long id) {
        Optional<Dojo> result = repository.findById(id);
        if(result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }
	
	
	public List<Dojo> all() {
        return repository.findAll();
	}
	
	
        
        

}
