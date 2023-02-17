package com.ty.spring_school_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ty.spring_school_app.dao.CartDao;
import com.ty.spring_school_app.dto.Cart;
import com.ty.spring_school_app.repo.CartRepo;
import com.ty.spring_school_app.util.ResponseStructure;

@Service
public class CartService {
	@Autowired
	private CartDao cartDao;
	@Autowired
	private CartRepo cartRepo;
	
	public ResponseEntity<ResponseStructure<Cart>> saveCart(Cart  cart){
		ResponseStructure<Cart> responseStructure=new ResponseStructure<>();
	     Cart cart2=cartDao.saveCart(cart);
	     if(cart2!=null) {
	    	 responseStructure.setMessage("saved succesfully");
	    	 responseStructure.setStatus(HttpStatus.CREATED.value());
	    	 responseStructure.setData(cart2);
	     }
	     return new ResponseEntity<ResponseStructure<Cart>>(responseStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Cart>> updateCart(int id,Cart  cart){
		ResponseStructure<Cart> responseStructure=new ResponseStructure<>();
		if(cartRepo.findById(id).isPresent()) {
			Cart cart1=cartDao.updateCart(id, cart);
			responseStructure.setData(cart1);
			responseStructure.setMessage("updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			 return new ResponseEntity<ResponseStructure<Cart>>(responseStructure,HttpStatus.OK);
			
		}else {
			responseStructure.setData(null);
			responseStructure.setMessage("id not preseent");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			 return new ResponseEntity<ResponseStructure<Cart>>(responseStructure,HttpStatus.NOT_FOUND);
		}
		 
		
	}

}
