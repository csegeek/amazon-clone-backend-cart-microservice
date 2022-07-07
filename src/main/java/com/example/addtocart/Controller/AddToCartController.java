package com.example.addtocart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.addtocart.Entity.Cart;
import com.example.addtocart.Entity.CartDetails;
import com.example.addtocart.Service.AddToCartService;

@RestController
@RequestMapping("/amazon/addToCart")
public class AddToCartController {
    @Autowired
	AddToCartService addToCartService;
	
	@PostMapping("/add")
	public void addToCart(@RequestBody Cart cart) {
		addToCartService.addItemTOCartService(cart);
	}
	
	@DeleteMapping("/remove")
	public void removeFromCart(@RequestBody Cart cart) {
		addToCartService.removeItemFromCartService(cart);
	}
	
	@GetMapping("/show/{userId}")
	public CartDetails showItems(@PathVariable String userId) {
		return addToCartService.displayAllProductsInCart(userId);
	}
}
