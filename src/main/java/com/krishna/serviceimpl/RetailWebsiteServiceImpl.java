package com.krishna.serviceimpl;

import javax.inject.Inject;
import javax.inject.Named;

import com.krishna.dao.IRetailWebsiteDao;
import com.krishna.dto.CustomerHolder;
import com.krishna.entity.CustomerDetails;
import com.krishna.service.IRetailWebsiteService;

/**
 * @author krishnachennamsetti
 *
 */

@Named
public class RetailWebsiteServiceImpl implements IRetailWebsiteService {

	@Inject
	IRetailWebsiteDao retailDao;

	@Override
	public String registerNewCustomer(CustomerHolder customerHolder) {

		return retailDao.registerNewCustomer(customerHolder);

	}

	@Override
	public CustomerHolder loadCustomerDetails(String customerId) {

		CustomerHolder customerHolder = new CustomerHolder();

		CustomerDetails customer = retailDao.loadCustomerDetails(customerId);

		if (null != customer) {

			customerHolder.setCustomerId(String.valueOf(customer.getCustomerId()));
			customerHolder.setCustomerName(customer.getCustomerName());
			customerHolder.setGender(customer.getGender());
			customerHolder.setAddress(customer.getAddress());
			customerHolder.setEmail(customer.getEmail());
			customerHolder.setTelephone(customer.getTelephone());
			customerHolder.setCustomerType(customer.getCustomerType());
			customerHolder.setCreatedDate(customer.getCreatedDate());

		}

		return customerHolder;
	}

}
