package fr.norsys.dojo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShoppingCart implements Serializable {
	private static final long serialVersionUID = -4461143736086272397L;
	
	private Map<Long, ShoppingCartLine> items = new HashMap<Long, ShoppingCartLine>();
	
	public ShoppingCart() {
	}
	
	public List<ShoppingCartLine> getItems() {
		List<ShoppingCartLine> list = new ArrayList<ShoppingCartLine>(items.values());
		Collections.sort(list);
		return list;
	}
	
	public void addItem(Product product) {
		long productId = product.getId();
		ShoppingCartLine item = items.get(productId);
		if (item != null) {
			item.incrementQuantity();
		} else {
			items.put(productId, new ShoppingCartLine(product, 1));
		}
	}
	
	public int getItemCount() {
		int count = 0;
		for (ShoppingCartLine item : items.values()) {
			count += item.getQuantity();
		}
		return count;
	}
	
	public double getTotalPrice() {
		double total = 0;
		for (ShoppingCartLine item : items.values()) {
			total += item.getTotalPrice();
		}
		return total;
	}
	
	public void clear() {
		items.clear();
	}
}
