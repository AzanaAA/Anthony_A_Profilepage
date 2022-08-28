package com.codingdojo.expenses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.expenses.models.Expense;
import com.codingdojo.expenses.repositories.ExpenseRepository;

@Service
public class ExpenseService {

private final ExpenseRepository repo;
    
    public ExpenseService(ExpenseRepository repo) {
        this.repo = repo;
    }
    
    
    public List<Expense> all() {
        return repo.findAll();
    }
    
    
    
    public Expense create(Expense b) {
        return repo.save(b);
    }
    
    
    
    public Expense update(Expense b) {
        return repo.save(b);
    }
    
    
    
    public Expense find(Long id) {
        Optional<Expense> optional = repo.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    
    
    
    public void delete(Long id) {
    	repo.deleteById(id);
    }

	
	
	
}
