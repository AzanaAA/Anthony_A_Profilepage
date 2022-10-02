package com.codingdojo.yoga.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.yoga.models.Course;
import com.codingdojo.yoga.models.User;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {
	public List<Course> findAll();
	Optional<Course> findById(Long id);
	List<Course> findAllByUser(User user);

}
