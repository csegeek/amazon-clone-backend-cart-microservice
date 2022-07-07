package com.example.addtocart.Entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;




@Entity(name="Cart")
public class Cart {
    @Id
	@GeneratedValue
	public long id;

    @Column(name = "userId", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
	public String userId;
    
    @Column(name = "productId", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
	public UUID productId;
	
	public Cart() {
		super();
	
	}

	public Cart(long id, String userId, UUID productId) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
    }
    
}
