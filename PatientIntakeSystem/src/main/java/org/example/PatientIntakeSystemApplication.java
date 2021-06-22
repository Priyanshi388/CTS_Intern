package org.example;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientIntakeSystemApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientIntakeSystemApplication.class);
	private static ClinicCalendar calendar = new ClinicCalendar();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		LOGGER.info("Welcome!" + "\n" + "Select an option?");
		int choice = 0;
		do {
			LOGGER.info("\n1. Add a patient appointment" + "\n" + "2. View all appointments" + "\n" + "3. Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				addPatientAppointment();
				break;
			case 2:
				viewAllAppointments();
				break;
			}
		} while (choice != 3);

		LOGGER.info("Thank You!!!");
	}

	private static void addPatientAppointment() {
		Scanner sc = new Scanner(System.in);
		LOGGER.info("Enter patient name:");
		String patientName = sc.nextLine();
		LOGGER.info("Enter appointment date and time (dd/MM/yyyy):");
		String appointmentTime = sc.nextLine();
		LOGGER.info("Enter doctor value:");
		String doctorName = sc.nextLine();

		try {
			calendar.addAppointment(patientName, appointmentTime, doctorName);
			LOGGER.info("Patient added sucessfully");
		} catch (Throwable t) {
			System.out.println(t.getMessage());
			return;
		}
	}

	private static void viewAllAppointments() {
		List<PatientAppointment> appointmentsList = calendar.getAppointmentsList();
		if (appointmentsList.isEmpty())
			LOGGER.info("No appointments");
		else {
			for (PatientAppointment appointments : appointmentsList) {
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				String datetime = df.format(appointments.getAppointmentDateTime());

				LOGGER.info("Patient Name: " + appointments.getPatientName() + "\n" + "Appointment Date Time: "
						+ datetime + "\n" + "Doctor Name: " + appointments.getDoctor().getDoctorName() + "\n");
			}
		}
	}
}
