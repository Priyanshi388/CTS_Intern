package org.example;

import java.util.List;
import java.util.Scanner;

import org.example.model.Trainee;
import org.example.service.TraineeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class TraineeManager1Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(TraineeManager1Application.class);
	public static void main(String[] args) {
		//Logger logger=LoggerFactory.getLogger(TraineeManager1Application.class);
		ApplicationContext ctx=SpringApplication.run(TraineeManager1Application.class, args);
		TraineeService ss=(TraineeService)ctx.getBean(TraineeService.class);
		Integer port=8080;
        String serverName="MyServer";
        LOGGER.info("Server is running on Port: {} ",port);
        LOGGER.error("Error in Null Value");
        LOGGER.warn("This is Warning Message");

		Scanner sc = new Scanner(System.in);

		LOGGER.info("Choose option for Trainee:");
		int choice = 0;
		do {
			LOGGER.info("\n1. Register " + "\n" + "2. remove " + "\n"
					+ "3. Find by name " + "\n" + "4. Find by cohort code" + "\n" + "5.Print All"+"\n"+"6.Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				sc.nextLine();
				LOGGER.info("Enter trainee name:");
				String name = sc.nextLine();
				LOGGER.info("Enter email:");
				String email = sc.next();
				
				LOGGER.info("Enter cohort code");
				String cohortCode = sc.next();
				
				LOGGER.info("Enter Emp ID");
				int ID=sc.nextInt();
				String result=ss.createTrainee(new Trainee(ID,name,email,cohortCode));
				LOGGER.info(result);
				break;
			
			case 2:
				LOGGER.info("Enter trainee id to remove");
				int id = sc.nextInt();

				String result1=ss.removeTrainee(id);
				LOGGER.info(result1);
				break;
				
			case 3: 
				LOGGER.info("Enter trainee name to find");
				String traineeName = sc.next();
				
				List<Trainee> li=ss.searchTraineeByName(traineeName);
				li.stream().forEach(System.out::println);
				
				break;
			
			case 4:
				LOGGER.info("Enter cohort code to find");
				String code = sc.next();
				
				List<Trainee> li1=ss.findAllTraineeByCohort(code);
				li1.stream().forEach(System.out::println);			
				break;
			case 5:
				LOGGER.info("All Trainer Details");
				List<Trainee> li2=ss.getAllTrainee();
				li2.stream().forEach(System.out::println);
				break;
			default:
				break;
			}
		} while (choice != 6);

		LOGGER.info("Thank You!!!");
		sc.close();
		
//		String result=ss.createTrainee(new Trainee(0,"Priyanshi", "priyanshi@gmail.com","AAA12AA37"));
//		System.out.println(result);
//		System.out.println("in main");
//		String result=ss.removeTrainee(4);
//		System.out.println(result);
//		List<Trainee> li=ss.searchTraineeByName("Saloni");
//		li.stream().forEach(System.out::println);
//		List<Trainee> li=ss.getAllTrainee();
//		li.stream().forEach(System.out::println);
	}
}
