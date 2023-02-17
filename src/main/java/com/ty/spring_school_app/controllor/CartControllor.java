package com.ty.spring_school_app.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.spring_school_app.dao.CartDao;
import com.ty.spring_school_app.dto.Cart;
import com.ty.spring_school_app.service.CartService;
import com.ty.spring_school_app.util.ResponseStructure;

@RestController
public class CartControllor {
	@Autowired
	private CartDao dao;
	@Autowired
	private CartService cartService;
	@PostMapping("/savecart")
	public ResponseEntity<ResponseStructure<Cart>> saveCart(@RequestBody Cart cart) {
		return cartService.saveCart(cart);
	}
	@DeleteMapping("/deletecart")
	public Cart deleteCart(@RequestParam int  id) {
		return dao.deleteCart(id);
	}
	@GetMapping("/getcart/{id}")
	public Cart getCart(@PathVariable int id) {
		return dao.getCart(id);
	}
		
	@PutMapping("/updatecart")
	public ResponseEntity<ResponseStructure<Cart>> updateCart(@RequestParam int c_id,@RequestBody Cart cart) {
		return cartService.updateCart(c_id, cart);
	}


}
