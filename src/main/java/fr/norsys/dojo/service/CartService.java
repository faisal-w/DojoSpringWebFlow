package fr.norsys.dojo.service;

import java.util.List;

import fr.norsys.dojo.model.Product;
import fr.norsys.dojo.model.ShoppingCart;

public interface CartService {
	
	ShoppingCart getShoppingCart();
	
	List<Product> getProducts();
		
	Product getProduct(long productId);
	
	List<String> getShippingOptions();
	
	void submitOrderForPayment();
}
