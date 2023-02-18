package com.hakanboranbay.billingapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hakanboranbay.billingapp.domain.Company;
import com.hakanboranbay.billingapp.domain.Month;

public class CompanyRepository {

	private List<Company> companyList;
	
	public CompanyRepository() {
		companyList = new ArrayList<>();
	}
	
	public List<Company> listAll() {
		return companyList;
	}
	
	public int saveCompany(Company c) {
		if (companyList.contains(c)) return -1;
		companyList.add(c);
		return c.getId();
	}
	
	public List<Company> filterNameByLetter(String letter) {
		return companyList.stream().filter(i -> i.getName().contains(letter)).collect(Collectors.toList());
    }
	
	public List<Company> filterByRegistrationMonth(Month month) {
		return companyList.stream().filter(i -> i.getRegistrationMonth().equals(month)).collect(Collectors.toList());
	}
	
}
