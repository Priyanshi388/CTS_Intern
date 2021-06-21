package org.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.example.model.Trainee;

@Repository
public interface TraineRepo  extends JpaRepository<Trainee, Integer> {
	@Query("select t from Trainee t where t.cohortCode=:n")
	public List<Trainee> findAllTraineeByCohort(@Param("n") String cohortCode);
	
	@Query("select t from Trainee t where t.name=:n")
	public List<Trainee> findTraineeByName(@Param("n") String name);
}
