package com.truyum.model;

import java.beans.Transient;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity

public class Cart {

	public Cart() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="ct_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	@OneToOne
	@JoinColumn(name = "ct_us_id")
	private User user;
	@ManyToMany(mappedBy = "cartset", fetch = FetchType.EAGER )

	
	private Set<MenuItem>  menuItemList;
	
	
	private double total;
	
	

	public Cart(User user) {
		super();
		this.user = user;
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(Set<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	@Transient
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [user=" + user + ", total=" + total + "]";
	}
	
	

}
