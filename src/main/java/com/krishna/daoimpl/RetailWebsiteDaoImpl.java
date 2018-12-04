package com.krishna.daoimpl;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.krishna.dao.IRetailWebsiteDao;
import com.krishna.dto.CustomerHolder;
import com.krishna.dto.HibernateUtil;
import com.krishna.entity.CustomerDetails;

/**
 * @author krishnachennamsetti
 *
 */
@Named
public class RetailWebsiteDaoImpl implements IRetailWebsiteDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.krishna.dao.IRetailWebsiteDao#registerNewCustomer(com.krishna.dto.
	 * CustomerHolder)
	 */
	@Override
	public String registerNewCustomer(CustomerHolder customerHolder) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			if(null!=session) {
				session.beginTransaction();
				CustomerDetails customer = new CustomerDetails();
				customer.setCustomerName(customerHolder.getCustomerName());
				customer.setGender(customerHolder.getGender());
				customer.setAddress(customerHolder.getAddress());
				customer.setCreatedDate(customerHolder.getCreatedDate());
				customer.setEmail(customerHolder.getEmail());
				customer.setTelephone(customerHolder.getTelephone());
				customer.setCustomerType(customerHolder.getCustomerType());
				session.save(customer);
				session.getTransaction().commit();
				return "Success";
			} else {
				return "Failed";
			}
		} catch (HibernateException exception) {
			
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw exception;
			
		} finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.krishna.dao.IRetailWebsiteDao#loadCustomerDetails(java.lang.String)
	 */
	@Override
	public CustomerDetails loadCustomerDetails(String customerId) {

		CustomerDetails customer = new CustomerDetails();

		Session session = null;


		try {
			session = HibernateUtil.getSessionFactory().openSession();
			if(null!=session) {
				session.beginTransaction();
				Criteria criteria = session.createCriteria(CustomerDetails.class);
				criteria.add(Restrictions.eq("customerId",Integer.parseInt(customerId)));
				customer = (CustomerDetails) criteria.uniqueResult();
				session.getTransaction().commit();
			}
			
		} catch (Exception exception) {
			customer = new CustomerDetails();
			session.getTransaction().rollback();
			throw exception;
		} finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}

		return customer;
	}

}
