package com.truyum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter

public class User {

	
	@Id
	@Column(name="us_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column(name="us_name")
	private String userName;
	@OneToOne
	private  Cart cart;
	
	
	public User (String userName) {
		this.userName=userName;
	}
	
	public User () {
		
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}
	
	

}
