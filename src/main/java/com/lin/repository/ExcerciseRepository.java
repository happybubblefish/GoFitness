package com.lin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lin.model.Exercise;

//Long refers to the type of id in Exercise
@Repository("exerciseRepository")
public interface ExcerciseRepository extends JpaRepository<Exercise, Long> {
	
}
