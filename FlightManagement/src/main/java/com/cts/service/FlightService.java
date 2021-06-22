package com.cts.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Flight;
import com.cts.model.Passenger;
import com.cts.repository.FligtRepo;

@Service
public class FlightService {
	private static final Logger LOGGER=LoggerFactory.getLogger(FlightService.class);
	@Autowired
	private FligtRepo flightRepo;
	List<Passenger> passList;
	public boolean addPassenger(Flight flight,Passenger passenger) {
		boolean flag=false;
		if(flight.getFlightType().equals("economy")) {
			flag=addGivenPassenger(flight,passenger);
		}else {
			if(passenger.isVip()) {
				flag=addGivenPassenger(flight, passenger);
			}else {
				LOGGER.info("Non VIP Passenger can not be added in Business class!");
				flag=false;
			}
		}
		return flag;
		
	}
	
	private boolean addGivenPassenger(Flight flight, Passenger passenger) {
		flightRepo.delete(flight);
		passList=flight.getPassengers();
		passList.add(passenger);
		flight.setPassengers(passList);
		return flightRepo.save(flight) != null; 
	}

	public boolean removePassenger(Flight flight,Passenger passenger) {
		boolean flag=false;
		if(passenger.isVip() && flight.getFlightType().equals("business")) {
			flag=false;
			LOGGER.info("VIP Passengers can not be removed from business class!");
		}else {
			flag=removeGivenPassenger(flight,passenger);
		}
		return flag;
	}

	private boolean removeGivenPassenger(Flight flight, Passenger passenger) {
		flightRepo.delete(flight);
		passList=flight.getPassengers();
		passList.remove(passenger);
		flight.setPassengers(passList);
		return flightRepo.save(flight) != null; 
	}

	public List<Flight> getAll() {
		return flightRepo.findAll();
	}

	public Flight addFlight(Flight flight) {
		flightRepo.save(flight);
		return getFlight(flight.getId());
	}

	public Flight getFlight(int flightId) {
		return flightRepo.findById(Integer.toString(flightId)).get();
	}
}
