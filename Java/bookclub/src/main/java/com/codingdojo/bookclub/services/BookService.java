package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.repositories.BookRepository;

@Service
public class BookService{
	
	@Autowired
	private BookRepository repository;
	
	public Book findById(Long id){
		
		Optional<Book> result = repository.findById(id);
		if(result.isPresent()){
			return result.get();
		}
		
		return null;
	}
	

	public List<Book> all(){
		return repository.findAll();
	}
	
	
	
	public Book update(Book book){
		return repository.save(book);
	}
	
	
	
	public Book create(Book book){
		return repository.save(book);
	}
	
	
	
	public void delete(Book book){
		repository.delete(book);
	}

}
