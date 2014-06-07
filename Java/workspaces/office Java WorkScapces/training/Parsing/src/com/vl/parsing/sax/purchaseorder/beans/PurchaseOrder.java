package com.vl.parsing.sax.purchaseorder.beans;

public class PurchaseOrder {
	private OrderItems orderItems;
	private ShippingAddress shippingAddress;
	public OrderItems getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(OrderItems orderItems) {
		this.orderItems = orderItems;
	}
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
}
