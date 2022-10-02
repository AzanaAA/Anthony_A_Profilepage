package com.codingdojo.yoga.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.yoga.models.Course;
import com.codingdojo.yoga.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	Optional<User> findByEmail (String email);
	User findByIdIs(Long id);
	List<User> findAll();
	List<User> findAllByCourses (Course course);

	
	

}
