package com.app.hro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private long purchasedBy;

	@Column
	private String items;

	@Column
	private String quantities;

	@Column
	private long totalCost;

	public Cart() {

	}

	public Cart(long purchasedBy, String items, String quantities, long totalCost) {
		this.purchasedBy = purchasedBy;
		this.items = items;
		this.quantities = quantities;
		this.totalCost = totalCost;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPurchasedBy() {
		return purchasedBy;
	}

	public void setPurchasedBy(long purchasedBy) {
		this.purchasedBy = purchasedBy;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getQuantities() {
		return quantities;
	}

	public void setQuantities(String quantities) {
		this.quantities = quantities;
	}

	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", purchasedBy=" + purchasedBy + ", items=" + items + ", quantities=" + quantities
				+ ", totalCost=" + totalCost + "]";
	}

}
