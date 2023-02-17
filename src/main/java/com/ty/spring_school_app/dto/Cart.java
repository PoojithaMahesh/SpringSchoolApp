package com.ty.spring_school_app.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
    private int c_id;
	private String name;
	private String email;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Items> items;
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Cart [c_id=" + c_id + ", name=" + name + ", email=" + email + ", items=" + items + "]";
	}
	
}
