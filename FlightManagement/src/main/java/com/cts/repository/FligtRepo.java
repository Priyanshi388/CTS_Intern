package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Flight;
@Repository
public interface FligtRepo extends JpaRepository<Flight, String> {

}
