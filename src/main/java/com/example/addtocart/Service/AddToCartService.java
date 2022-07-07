package com.example.addtocart.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.addtocart.Entity.Cart;
import com.example.addtocart.Entity.CartDetails;
import com.example.addtocart.Entity.Product;
import com.example.addtocart.Repository.CartRepo;

@Service

public class AddToCartService {
     @Autowired 
     CartRepo cartRepo;
     @Autowired 
     ProductDetailProxy productDetailProxy;

    public void addItemTOCartService(Cart cart){
         
          cartRepo.save(cart);
    }

   public void removeItemFromCartService(Cart cart){
      String userId=cart.getUserId();
      UUID productId=cart.getProductId();
      cartRepo.delete(userId,productId);
   }

   public CartDetails displayAllProductsInCart(String userId) {
      CartDetails cartDetails=new CartDetails();
      cartDetails.setUserId(userId);
      
     List<Cart> cartList = cartRepo.findByuserId(userId);
     List<Product> productList=new ArrayList<Product>();
      
      for(int i=0;i<cartList.size();i++) {
            Product product=productDetailProxy. getById(cartList.get(i).getProductId());
            productList.add(product);
      }
      
      cartDetails.setList(productList);	
      return cartDetails;
      
}

}
 