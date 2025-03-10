package org.example.data;


import org.example.data.entities.Cart;
import org.example.data.entities.CartItem;
import org.example.data.entities.Product;

import java.util.List;

public interface CartItemDao{

	List<CartItem> findUserByProduct(Product product);

	void save(CartItem cartItem);

	void removeByCart(Cart cart);
	
	List<CartItem> findAllCartItemsBycart(Cart cart);
	
//	@Modifying
//	@Transactional
//	@Query(value="DELETE  FROM cartItem  WHERE cartItemId = :cartItemId ",nativeQuery=true)
    void deleteCartItemById(long cartItemId);
//
	
	
	
}
