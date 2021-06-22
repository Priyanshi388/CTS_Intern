package com.cognizant.patientintakesystem;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.example.ClinicCalendar;
import org.example.PatientAppointment;
import org.junit.jupiter.api.Test;

//@SpringBootTest
class PatientIntakeSystemApplicationTests {

	@Test
	void addAppointment() throws ParseException {
		ClinicCalendar calendar = new ClinicCalendar();
		calendar.addAppointment("sarah", "03/12/2021", "sam");

		// verifying added appointment
		List<PatientAppointment> appointments = calendar.getAppointmentsList();
		assertEquals(1, appointments.size());

		// verifying date
		PatientAppointment appointment = appointments.get(0);
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String datetime = df.format(appointment.getAppointmentDateTime());
		assertEquals("03/12/2021", datetime);
	}

	@Test
	void invalidDateAppointment() throws ParseException {
		ClinicCalendar calendar = new ClinicCalendar();
		assertThrows(ParseException.class, () -> calendar.addAppointment("alex", "03-09-2020", "sam"));
	}

}
