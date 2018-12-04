package com.krishna.dao;

import com.krishna.dto.CustomerHolder;
import com.krishna.entity.CustomerDetails;

/**
 * @author krishnachennamsetti
 *
 */
public interface IRetailWebsiteDao {

	String registerNewCustomer(CustomerHolder customerHolder);
	
	CustomerDetails loadCustomerDetails(String customerId);
	
	
}
