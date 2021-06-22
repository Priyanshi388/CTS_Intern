package com.cts.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Embeddable  
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
	
	/*public Passenger(String string, boolean b) {
		// TODO Auto-generated constructor stub
		this.name=string;
		this.vip=b;
	}*/
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//private int passId;
	@Column(columnDefinition = "varchar(10) default 'noname'")
	private String name;
	private boolean vip;
	/*@ManyToOne
	@JoinColumn(name="passengers_id")
	private Flight flight;*/
}
