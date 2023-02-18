package com.hakanboranbay.billingapp.service;

import java.util.ArrayList;
import java.util.List;

import com.hakanboranbay.billingapp.domain.Company;
import com.hakanboranbay.billingapp.domain.Month;
import com.hakanboranbay.billingapp.domain.Order;
import com.hakanboranbay.billingapp.domain.Sector;
import com.hakanboranbay.billingapp.repository.CompanyRepository;
import com.hakanboranbay.billingapp.repository.OrderRepository;

public class BillingService {

	private CompanyRepository companyRepository;
	private OrderRepository orderRepository;
	
	public BillingService() {
		this.companyRepository = new CompanyRepository();
		this.orderRepository = new OrderRepository();
	}
	
	public int createCompany(String name, Sector sector, Month month) {
		Company company = new Company(name, sector, month);
		companyRepository.saveCompany(company);
		return company.getId();
	}
	
	public int createOrder(int companyID, Month month, float amount) {
		Order order = new Order(month, amount);
		order.setCompanyId(companyID);
		orderRepository.saveOrder(order);
		return order.getId();
	}
	
	public List<Company> listAllCompanies() {
		return companyRepository.listAll();
	}
	
	public List<Company> listCompaniesHavingLetter(String letter) {
		return companyRepository.filterNameByLetter(letter);
	}
	
	public List<Company> listCompaniesByRegisteredMonth(Month month) {
		return companyRepository.filterByRegistrationMonth(month);
	}
	
	public List<Order> listAllOrders() {
		return orderRepository.listAll();
	}
	
	public List<Order> listOrdersAboveInvoiceAmount(float amount) {
		return orderRepository.filterOrdersAboveAmount(amount);
	}
	
	public List<Order> listOrdersBeloveInvoiceAmount(float amount) {
		return orderRepository.filterOrdersBeloveAmount(amount);
	}
	
	public List<String> listCompaniesByOrderInvoiceAmount(float amount) {
		List<String> companyNames = new ArrayList<>();
		for (Order o : orderRepository.filterOrdersBeloveAmount(amount)) {
			for(Company c : companyRepository.listAll()) {
				if (o.getCompanyId() == c.getId()) companyNames.add(c.getName());
			}
		}
		return companyNames;
	}
	
	public float calculateAverageOfOrdersAboveAmount(float amount) {
		float sum = 0;
		int counter = 0;
		for (Order o : orderRepository.filterOrdersAboveAmount(amount)) {
			if (o.getInvoiceAmount() >= amount) {
				sum += o.getInvoiceAmount();
				counter++;
			}
		}
		return sum / counter;
	}
	
}
