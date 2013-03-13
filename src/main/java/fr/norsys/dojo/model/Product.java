package fr.norsys.dojo.model;

import java.io.Serializable;

public class Product implements Comparable<Product>, Serializable {
	private static final long serialVersionUID = -6027340279914938585L;

	private long id;
	private String description;
	private double price;
	private String imageUrl;

	public Product(long id, String description, double price,
			String imageUrl) {
		this.id = id;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Product && id == ((Product) o).id;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	public int compareTo(Product p) {
		int c = description.compareTo(p.description);
		return (c == 0 ? ((Long) id).compareTo((Long) p.id) : c);
	}
}
