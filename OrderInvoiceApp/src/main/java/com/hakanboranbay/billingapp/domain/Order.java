package com.hakanboranbay.billingapp.domain;

public class Order {

	private int idIncrement = 1;
	private int id;
	private int companyId;
	private Month orderDate;
	private float invoiceAmount;
	
	public Order(Month orderDate, float invoiceAmount) {
		if (invoiceAmount <= 0) return;
		this.id = idIncrement;
		this.orderDate = orderDate;
		this.invoiceAmount = invoiceAmount;
		idIncrement++;
	}
	
	public int getId() {
		return id;
	}

	public int getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public Month getOrderDate() {
		return orderDate;
	}

	public float getInvoiceAmount() {
		return invoiceAmount;
	}
	
	@Override
	public String toString() {
		return String.format("Company ID: %d%n"
				+ "Invoice Amount: %f%n"
				+ "Order Month: %s%n"
				, companyId, invoiceAmount, orderDate);
	}
	
}
