package com.example.addtocart.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.addtocart.Entity.Cart;
@Repository
public interface CartRepo extends CrudRepository< Cart,Long> {
    Cart save(Cart cart);
	@Transactional
    @Modifying
	@Query(value = " DELETE FROM Cart c WHERE c.userId =:userId AND c.productId =:productId")
	void delete( String userId,UUID productId);
	List<Cart> findByuserId(String userId);
	Cart findByproductId(UUID productId);
}
