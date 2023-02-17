package com.ty.spring_school_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.spring_school_app.dto.Cart;
import com.ty.spring_school_app.dto.Items;
import com.ty.spring_school_app.repo.CartRepo;

@Repository
public class CartDao {
	@Autowired
private CartRepo cartRepo;
	public Cart saveCart(Cart cart) {
		return cartRepo.save(cart);
	}
	public Cart deleteCart(int id) {
		Cart cart=cartRepo.findById(id).get();
		cartRepo.delete(cart);
		return cart;
	}
	public Cart getCart(int id) {
		return cartRepo.findById(id).get(); 
	}
	public Cart updateCart(int id,Cart cart) {
		Cart cart2=cartRepo.findById(id).get();

		if(cart2!=null ) {
			cart.setC_id(id);
			return cartRepo.save(cart);
		}
		return null;
	}
	

}
