package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.Flight;
import com.cts.model.Passenger;
import com.cts.service.FlightService;

@SpringBootTest
class FlightManagementApplicationTests {
	FlightService flightService;

	@Test
	void addEconomyFlight() {
		Flight flight = new Flight();
		flight.setId(1);
		flight.setFlightType("economy");
		flightService.addFlight(flight);
		flight=flightService.getFlight(1);
		assertNotNull(flight);
	}
	@Test
	void addBusinessFlight() {
		Flight flight = new Flight();
		flight.setId(2);
		flight.setFlightType("business");
		flightService.addFlight(flight);
		flight=flightService.getFlight(2);
		assertNotNull(flight);
	}
	@Test
	void addVipToEconomy() {
		Flight flight = new Flight();
		flight=flightService.getFlight(1);
		Passenger passenger=new Passenger();
		passenger.setName("sam");
		passenger.setVip(true);
		flightService.addPassenger(flight, passenger);
		assertNotNull(flightService.getFlight(flight.getId()));
	}
	
	@Test
	void addVipToBusiness() {
		Flight flight = new Flight();
		flight=flightService.getFlight(2);
		Passenger passenger=new Passenger();
		passenger.setName("dean");
		passenger.setVip(true);
		flightService.addPassenger(flight, passenger);
		assertNotNull(flightService.getFlight(flight.getId()));
	}
	
	@Test
	void addNonVipToEconomy() {
		Flight flight = new Flight();
		flight=flightService.getFlight(1);
		Passenger passenger=new Passenger();
		passenger.setName("bobby");
		passenger.setVip(false);
		flightService.addPassenger(flight, passenger);
		assertNotNull(flightService.getFlight(flight.getId()));
		}
	
	@Test
	void addNonVipToBusiness() {
		Flight flight = new Flight();
		flight=flightService.getFlight(2);
		Passenger passenger=new Passenger();
		passenger.setName("adam");
		passenger.setVip(false);
		flightService.addPassenger(flight, passenger);
		assertNull(flightService.getFlight(flight.getId()));
	}
	@Test
	void RemoveVIPFromEconomy() {
		Flight flight = new Flight();
		flight=flightService.getFlight(1);
		Passenger passenger=new Passenger();
		passenger.setName("sam");
		passenger.setVip(true);
		flightService.removePassenger(flight, passenger);
		assertNull(flightService.getFlight(flight.getId()));
	}
	@Test
	void RemoveVIPFromBusiness() {
		Flight flight = new Flight();
		flight=flightService.getFlight(2);
		Passenger passenger=new Passenger();
		passenger.setName("dean");
		passenger.setVip(true);
		flightService.removePassenger(flight, passenger);
		assertNotNull(flightService.getFlight(flight.getId()));	}
	@Test
	void RemoveNonVIPFromEconomy() {
		Flight flight = new Flight();
		flight=flightService.getFlight(1);
		Passenger passenger=new Passenger();
		passenger.setName("bobby");
		passenger.setVip(false);
		flightService.removePassenger(flight, passenger);
		assertNull(flightService.getFlight(flight.getId()));
		
	}
	@Test
	void RemoveNonVIPFromBusiness() {
		Flight flight = new Flight();
		flight=flightService.getFlight(2);
		Passenger passenger=new Passenger();
		passenger.setName("adam");
		passenger.setVip(false);
		flightService.removePassenger(flight, passenger);
		assertNull(flightService.getFlight(flight.getId()));
	}

}
