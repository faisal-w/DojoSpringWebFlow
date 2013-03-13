package fr.norsys.dojo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.norsys.dojo.model.Product;
import fr.norsys.dojo.model.ShoppingCart;

@Service("cartService")
public class CartServiceImpl implements CartService {
	
	@Autowired
	private ShoppingCart cart;
	
	private Map<Long, Product> products = new HashMap<Long, Product>();
	private List<String> shippingOptions = new ArrayList<String>();
	
	public CartServiceImpl() {
		addProduct(1L, "Kayak Freestyle", 699.90, "skittles.jpg");
		addProduct(2L, "Kayak Mer", 1299.90, "dieselboy.jpg");
		addProduct(3L, "Kayak Polo", 599.90, "vader.jpg");
		
		addShippingOption("Normal (5-10 jours)");
		addShippingOption("Rapide (24/48h)");
	}
	
	private void addProduct(Long id, String desc, double price, String imgUrl) {
		Product product = new Product(id, desc, price, imgUrl);
		products.put(id, product);
	}
	
	private void addShippingOption(String shippingOption) {
		shippingOptions.add(shippingOption);		
	}

	public ShoppingCart getShoppingCart() {
		return cart;
	}
	
	public void setShoppingCart(ShoppingCart cart) {
		this.cart = cart;
	}
	
	public List<Product> getProducts() {
		List<Product> list = new ArrayList<Product>(products.values());
		Collections.sort(list);
		return list;
	}
	
	public Product getProduct(long productId) {
		return products.get(productId);
	}
	
	
	public List<String> getShippingOptions() {
		return shippingOptions;
	}
	
	
	public void submitOrderForPayment() {
		cart.clear();
	}
}
