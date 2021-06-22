package org.example;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatientAppointment {
	private String patientName;
	private Date appointmentDateTime;
	private Doctor doctor;
}
