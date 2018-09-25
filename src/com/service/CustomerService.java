package com.service;

import com.domain.Customer;

import java.util.List;


/**
 * 客户管理的业务层的接口
 * @author jt
 *
 */
public interface CustomerService {

	void save(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);
	Customer findById(Long cust_id);
	List<Customer> findAllByHQL();
	List<Customer> findAllByQBC();
	List<Customer> findAllByNamedQuery();

}
