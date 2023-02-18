package com.hakanboranbay.billingapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hakanboranbay.billingapp.domain.Month;
import com.hakanboranbay.billingapp.domain.Order;

public class OrderRepository {

	private List<Order> orderList;
	
	public OrderRepository() {
		orderList = new ArrayList<>();
	}
	
	public List<Order> listAll() {
		return orderList;
	}
	
	public int saveOrder(Order order) {
		orderList.add(order);
		return order.getId();
	}
	
	public List<Order> filterOrdersAboveAmount(float amount) {
		return orderList.stream().filter(i -> i.getInvoiceAmount() >= amount).collect(Collectors.toList());
    }
	
	public List<Order> filterOrdersBeloveAmount(float amount) {
		return orderList.stream().filter(i -> i.getInvoiceAmount() < amount).collect(Collectors.toList());
	}
	
	public List<Order> filterByOrderMonth(Month month) {
		return orderList.stream().filter(i -> i.getOrderDate().equals(month)).collect(Collectors.toList());
	}
	
}
