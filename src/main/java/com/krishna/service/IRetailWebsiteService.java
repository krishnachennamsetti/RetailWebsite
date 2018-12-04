package com.krishna.service;

import com.krishna.dto.CustomerHolder;

/**
 * @author krishnachennamsetti
 *
 */
public interface IRetailWebsiteService {
	
    String registerNewCustomer(CustomerHolder customerHolder);
	
	CustomerHolder loadCustomerDetails(String customerId); 

}
