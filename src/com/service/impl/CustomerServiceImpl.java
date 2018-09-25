package com.service.impl;

import java.util.List;

import com.dao.CustomerDao;
import com.domain.Customer;
import com.service.CustomerService;
import org.springframework.transaction.annotation.Transactional;


/**
 * 客户管理的业务层的实现类
 * @author jt
 *
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {

	// 注入DAO;
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) {
		System.out.println("Service中的save方法执行了...");
		customerDao.save(customer);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	@Override
	public Customer findById(Long cust_id) {
		return customerDao.findById(cust_id);
	}

	@Override
	public List<Customer> findAllByHQL() {
		return customerDao.findAllByHQL();
	}

	@Override
	public List<Customer> findAllByQBC() {
		return customerDao.findAllByQBC();
	}

	@Override
	public List<Customer> findAllByNamedQuery() {
		return customerDao.findAllByNamedQuery();
	}

}
