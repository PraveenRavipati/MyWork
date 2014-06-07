package com.vl.parsing.sax.purchaseorder.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.vl.parsing.sax.purchaseorder.beans.Item;
import com.vl.parsing.sax.purchaseorder.beans.OrderItems;
import com.vl.parsing.sax.purchaseorder.beans.PurchaseOrder;
import com.vl.parsing.sax.purchaseorder.beans.ShippingAddress;


public class POHandler extends DefaultHandler{
	private PurchaseOrder order=null;
	private OrderItems items=null;
	private ShippingAddress shipping=null;
	private Item item=null;

	
	boolean itemName=false;
	boolean code=false;
	boolean name=false;
	boolean fatherName=false;
	boolean doorNo=false;
	boolean city=false;
	boolean distict=false;
	boolean street=false;
	boolean state=false;
	boolean country=false;
	
	public POHandler() {
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrder getOrder() {
		return order;
	}


	public void setOrder(PurchaseOrder order) {
		this.order = order;
	}

	public OrderItems getItems() {
		return items;
	}


	public void setItems(OrderItems items) {
		this.items = items;
	}


	public ShippingAddress getShipping() {
		return shipping;
	}


	public void setShipping(ShippingAddress shipping) {
		this.shipping = shipping;
	}
	
	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}

	
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("PurchaseOrder"))
		{
			if(order==null)
			{
				order=new PurchaseOrder();
			}
		}
		else if(qName.equalsIgnoreCase("OrderItems"))
		{
			if(items==null)
			{
				items=new OrderItems();
			}
		}
		else if (qName.equalsIgnoreCase("ShippingAddress")) {
			if(shipping==null)
			{
				shipping=new ShippingAddress();
			}
		}
		else if(qName.equalsIgnoreCase("Item"))
		{
			item=new Item();
		}
		else if (qName.equalsIgnoreCase("ItemName")) {
			itemName=true;
		}
		else if (qName.equalsIgnoreCase("Code")) {
			code=true;
		}
		else if (qName.equalsIgnoreCase("Name")) {
			name=true;
		}
		else if (qName.equalsIgnoreCase("FatherName")) {
			fatherName=true;
		}
		else if (qName.equalsIgnoreCase("DoorNo")) {
			doorNo=true;
		}
		else if (qName.equalsIgnoreCase("Street")) {
			street=true;
		}
		else if (qName.equalsIgnoreCase("City")) {
			city=true;
		}
		else if (qName.equalsIgnoreCase("Distict")) {
			distict=true;
		}
		else if (qName.equalsIgnoreCase("State")) {
			state=true;
		}
		else if (qName.equalsIgnoreCase("Country")) {
			country=true;
		}
		
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(itemName){
			item.setItemName(new String(ch,start,length));
			itemName=false;
		}
		else if (code) {
			item.setItemName(new String(ch,start,length));
			code=false;
		}
		else if (name) {
			shipping.setName(new String(ch,start,length));
			name=false;
		}
		else if (fatherName) {
			shipping.setFatherName(new String(ch,start,length));
			fatherName=false;
		}
		else if (doorNo) {
			shipping.setDoorNo(new String(ch,start,length));
			doorNo=false;
		}
		else if (street) {
			shipping.setStreet(new String(ch,start,length));
			street=false;
		}
		else if (city) {
			shipping.setCity(new String(ch,start,length));
			city=false;
		}
		else if (distict) {
			shipping.setDistict(new String(ch,start,length));
			distict=false;
		}
		else if (state) {
			shipping.setState(new String(ch,start,length));
			state=false;
		}
		else if (country) {
			shipping.setCountry(new String(ch,start,length));
			country=false;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(qName.equalsIgnoreCase("Item")){
			items.addItem(item);
		}
		else if (qName.equalsIgnoreCase("OrderItems")) {
			order.setOrderItems(items);
		}
		else if (qName.equalsIgnoreCase("ShippingAddress")) {
			order.setShippingAddress(shipping);
		}
		
	}
	
}
