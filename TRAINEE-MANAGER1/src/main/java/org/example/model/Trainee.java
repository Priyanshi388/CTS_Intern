package org.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
@Table(name="Trainer")
public class Trainee {
	@Id
	@Column(name="EmpId")
	private int empid;
	@Column(name="Name")
	private String name;
	@Column(name="Email")
	private String email;
	@Column(name="CohortCode")
	private String cohortCode;
	
	public String toString() {
		return name+"\t"+email+"\t"+cohortCode;
	}
	
}