package com.cts.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="flight")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
	@Id
	@GeneratedValue
	private int id;
	private String flightType;
	@Column(columnDefinition = "varchar(10) default 'none'")
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="flight",
	joinColumns = @JoinColumn(name="passengers"),
	inverseJoinColumns = @JoinColumn(name="name"))
	List<Passenger> passengers=new ArrayList<Passenger>();
	/*public boolean removePassenger(Passenger passenger) {
		return passengers.remove(passenger);
		
	}*/
}
