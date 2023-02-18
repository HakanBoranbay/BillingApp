package com.hakanboranbay.billingapp.main;

import com.hakanboranbay.billingapp.domain.Month;
import com.hakanboranbay.billingapp.domain.Sector;
import com.hakanboranbay.billingapp.service.BillingService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

    	BillingService billingService = new BillingService();
    	
    	billingService.createCompany("Central Bank", Sector.ECONOMY, Month.JUNE);
    	billingService.createCompany("DefineX", Sector.ENGINEERING, Month.JULY);
    	billingService.createCompany("Netflix", Sector.MEDIA, Month.AUGUST);
    	
    	billingService.createOrder(1, Month.JULY, 1500);
    	billingService.createOrder(2, Month.JULY, 700);
    	billingService.createOrder(2, Month.JULY, 750);
    	billingService.createOrder(2, Month.JULY, 2500);
    	billingService.createOrder(3, Month.JUNE, 1500);
    	billingService.createOrder(3, Month.JANUARY, 300);
    	
    	
    	System.out.println(billingService.listAllCompanies());
    	System.out.println("********************************************");
    	System.out.println(billingService.listCompaniesHavingLetter("C"));
    	System.out.println("********************************************");
    	System.out.println(billingService.listCompaniesByRegisteredMonth(Month.JUNE));
    	System.out.println("********************************************");
    	System.out.println(billingService.listAllOrders());
    	System.out.println("********************************************");
    	System.out.println(billingService.listOrdersAboveInvoiceAmount(1500));
    	System.out.println("********************************************");
    	System.out.println(billingService.calculateAverageOfOrdersAboveAmount(1500));
    	System.out.println("********************************************");
    	System.out.println(billingService.listOrdersBeloveInvoiceAmount(500));
    	System.out.println("********************************************");
    	
    }
}
