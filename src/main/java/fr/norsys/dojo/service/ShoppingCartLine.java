package fr.norsys.dojo.service;

import java.io.Serializable;

import fr.norsys.dojo.model.Product;

public class ShoppingCartLine implements Comparable<ShoppingCartLine>, Serializable {
	private static final long serialVersionUID = 4134652647253355430L;
	
	private Product product;
	private int quantity;
	
	public ShoppingCartLine(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void incrementQuantity() {
		quantity++;
	}

	public double getUnitPrice() {
		return product.getPrice();
	}
	
	
	public double getTotalPrice() {
		return (quantity * getUnitPrice());
	}
	
	
	@Override
	public boolean equals(Object o) {
		return o instanceof ShoppingCartLine &&
			product.equals(((ShoppingCartLine) o).product);
	}
	
	@Override
	public int hashCode() {
		return product.hashCode();
	}
	
	public int compareTo(ShoppingCartLine item) {
		return product.compareTo(item.product);
	}
}
