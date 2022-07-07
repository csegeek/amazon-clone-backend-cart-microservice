package com.example.addtocart.Service;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.addtocart.Entity.Product;

@FeignClient(name="product-details" ,url="amazon-clone-product-mservice.herokuapp.com")
public interface ProductDetailProxy {
    @GetMapping("/amazon/products/getById/{productID}")
    public Product getById(@PathVariable UUID productID);
}
