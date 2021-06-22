package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ClinicCalendar {
	private List<PatientAppointment> appointmentsList = new ArrayList<>();
	
	//Add the appointment details to the list
	public void addAppointment(String patientName, String appointmentTime, String doctor) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Doctor doctorName = Doctor.valueOf(doctor.toLowerCase());

		Date appDate1 = df.parse(appointmentTime);
		PatientAppointment newAppointment = new PatientAppointment(patientName, appDate1, doctorName);
		appointmentsList.add(newAppointment);
	}
	//Get the list of appointments
	public List<PatientAppointment> getAppointmentsList() {
		return appointmentsList;
	}
}
