package com.vl.parsing.sax.purchaseorder.beans;

import java.util.List;

public class OrderItems {
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	public void addItem(Item item){
		this.items.add(item);
	}
}
