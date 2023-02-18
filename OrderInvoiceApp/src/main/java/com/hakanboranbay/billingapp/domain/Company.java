package com.hakanboranbay.billingapp.domain;

public class Company {

	private int ID_INCREMENT = 1;
	private int id;
	private String name;
	private Sector sector;
	private Month registrationMonth;
	
	public Company(String name, Sector sector, Month registrationMonth) {
		this.id = this.ID_INCREMENT;
		this.name = name;
		this.sector = sector;
		this.registrationMonth = registrationMonth;
		this.ID_INCREMENT++;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Sector getSector() {
		return sector;
	}

	public Month getRegistrationMonth() {
		return registrationMonth;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s%n"
				+ "Sector: %s%n"
				+ "Registration Month: %s%n"
				, name, sector, registrationMonth);
	}
	
}
