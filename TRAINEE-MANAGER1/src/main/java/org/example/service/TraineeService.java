package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.example.exception.InvalidTraineeDataException;
import org.example.model.Trainee;

import org.example.repository.TraineRepo;

@Service
public class TraineeService {
	@Autowired
	private TraineRepo repo;
	public String createTrainee(Trainee t) {
		String validEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern emailPattern = Pattern.compile(validEmail);
		Matcher emailMatcher = emailPattern.matcher(t.getEmail());
		if (!emailMatcher.matches()) {
			throw new InvalidTraineeDataException("Make sure email is in correct format\n");
		}
		char[] chars = t.getName().toCharArray();
		for (char c : chars) {
			if (Character.isDigit(c))
				throw new InvalidTraineeDataException("Name cannot have numeric data");
		}
		if (String.valueOf(t.getEmpid()).length() != 6) {
			throw new InvalidTraineeDataException("Empid should have 6 numbers");
		}
		String validCohort = "^[A-Za-z]{3}[0-9]{2}[A-Za-z]{2}[0-9]{2}";
		Pattern cohortPattern = Pattern.compile(validCohort);
		Matcher cohortMatcher = cohortPattern.matcher(t.getCohortCode());
		if (!cohortMatcher.matches()) {
			throw new InvalidTraineeDataException("Error! Please enter with format AAAXXAAXX");
		}
		repo.saveAndFlush(t);
		return "Trainee Created!!!!";
	}
	public String removeTrainee(int empid){
		Optional<Trainee> op=repo.findById(empid);
		if(op.isPresent()) {
			repo.delete(op.get());
			return "Trainee Deleted!!!!";
		}	
		else {
			return "Trainee Not Available";
		}
			
	}
	public List<Trainee> searchTraineeByName(String name){
		return repo.findTraineeByName(name);
	}
	public List<Trainee> getAllTrainee(){
		return repo.findAll();
	}
	public List<Trainee> findAllTraineeByCohort(String cohortCode){
		return repo.findAllTraineeByCohort(cohortCode);
	}

}
