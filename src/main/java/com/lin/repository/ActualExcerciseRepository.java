package com.lin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lin.model.ActualExercise;

//Long refers to the type of id in Exercise
@Repository("actualExerciseRepository")
public interface ActualExcerciseRepository extends JpaRepository<ActualExercise, Long> {
	
}
