package com.truyum.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="menu_item")
public class MenuItem {
	@Id
	@Column(name = "me_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "me_name")
	private String name;
	@Column(name = "me_price")
	private double price;
	@Column(name = "me_active")
	private String active;
	@Column(name = "me_date_of_launch")
	private Date dateOfLaunch;
	@Column(name = "me_category")
	private String category;
	@Column(name = "me_free_delivery")
	private String freeDelivery; 
	@ManyToMany(fetch = FetchType.EAGER)

	@JoinTable(name = "menu_item_cart",

	joinColumns = @JoinColumn(name = "me_id"),

	inverseJoinColumns = @JoinColumn(name = "ct_pr_id"))
	private Set<Cart> cartset;
	

	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
				+ dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery 
				+ "]";
	}



	public MenuItem(int id, String name, double price, String active, Date dateOfLaunch, String category,
			String freeDelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public String getActive() {
		return active;
	}



	public void setActive(String active) {
		this.active = active;
	}



	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}



	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getFreeDelivery() {
		return freeDelivery;
	}



	public void setFreeDelivery(String freeDelivery) {
		this.freeDelivery = freeDelivery;
	}



	public Set<Cart> getCartset() {
		return cartset;
	}



	public void setCartset(Set<Cart> cartset) {
		this.cartset = cartset;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
