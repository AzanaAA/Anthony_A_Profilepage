package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private final NinjaRepository repository;
	
	public NinjaService(NinjaRepository repository) {
        this.repository = repository;
    }
	
	 public Ninja create(Ninja ninja) {
	        return repository.save(ninja);
	    }
	 
	 public Ninja find(Long id) {
	        Optional<Ninja> result = repository.findById(id);
	        if(result.isPresent()) {
	            return result.get();
	        } else {
	            return null;
	            }
	    }
	 
	 public List<Ninja> byDojo(Dojo dojo) {
	    	return repository.findAllByDojo(dojo);
	    }
	
	    public List<Ninja> all() {
	        return repository.findAll();
	    }
	    
	 

	

}
