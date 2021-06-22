package com.cts;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.model.Flight;
import com.cts.model.Passenger;
import com.cts.service.FlightService;

@SpringBootApplication
public class FlightManagementApplication {

	private static FlightService flightService;
	private static final Logger LOGGER=LoggerFactory.getLogger(FlightManagementApplication.class);

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(FlightManagementApplication.class, args);
		flightService = context.getBean(FlightService.class, args);
		Scanner sc=new Scanner(System.in);
		Flight flight=new Flight();
		Passenger passenger=new Passenger();
		LOGGER.info("Enter your choice:\n1. Add flight\n2. Add a passenger\n3. Delete a passenger\n4. Get all flight details\n5. Exit");
		int choice=sc.nextInt();
		sc.nextLine();
		while(choice!=6) {
			LOGGER.info("Enter your choice:\n1. Add flight\n2. Add a passenger\n3. Delete a passenger\n4. Get all flight details\n5. Exit");
			switch(choice) {
			case 1:LOGGER.info("Enter flight details");
			try {
			    LOGGER.info("Flight id:");
			    flight.setId(sc.nextInt());
			    sc.nextLine();
				LOGGER.info("Flight type(economy/business):");
				flight.setFlightType(sc.nextLine());
				Flight newFlight=flightService.addFlight(flight);
				if(newFlight!=null) {
					LOGGER.info("Flight added successfully");
				}else {
					LOGGER.info("Flight not added");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			case 2: LOGGER.info("Enter Flight id to add passenger:");
					try {
					Flight currentFlight=flightService.getFlight(sc.nextInt());
					LOGGER.info("passenger name:");
					passenger.setName(sc.nextLine());
					LOGGER.info("Is VIP? Give '1' for YES and '0' for NO");
				    String str=sc.nextLine();
				    boolean vip;
				    if(str=="1"){
				    	vip=true;
				    }else {
				    	vip=false;
				    }
					passenger.setVip(vip);
					if(flightService.addPassenger(currentFlight, passenger)) {
						LOGGER.info("Passenger added successfully in "+currentFlight.getFlightType()+" class");
					}else {
						LOGGER.info("Passenger addition failed");
					}
					LOGGER.info(flight.toString());
					}catch(Exception e){
						e.printStackTrace();
					}
					break;
					case 3: LOGGER.info("Enter Flight id to remove passenger:");
						try{
							Flight currentFlight=flightService.getFlight(sc.nextInt());
							if(flightService.removePassenger(currentFlight, passenger)) {
							LOGGER.info("Passenger deleted successfully in "+currentFlight.getFlightType()+" class");
							}else {
							LOGGER.info("Passenger deletion failed");
							}
							}catch(Exception e) {
								e.printStackTrace();
							}
							break;
					case 4:try {
						List<Flight> list=flightService.getAll();
						for(Flight f : list) {
							LOGGER.info(f.toString());
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
					break;
					case 5: choice=6;
					break;
					default:
						System.exit(0);
				}
		}
		LOGGER.info("Process done");
	}

}
