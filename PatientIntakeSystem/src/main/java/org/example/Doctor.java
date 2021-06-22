package org.example;

public enum Doctor {
	Nikit("Nikit Jain"),
	Kartik("Kartik sarraf"),
	Himanshu("Himanshu Soni"),
	Lokendra("lokendra singh");
	
	private String doctorName;
	
	private Doctor(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
}
