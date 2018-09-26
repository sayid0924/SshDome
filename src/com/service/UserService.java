package com.service;


import com.domain.User;
import com.domain.User;

import java.util.List;

/**
 * 用户管理的Service的接口
 * @author jt
 *
 */
public interface UserService {

	void save(User User);
	void update(User User);
	void delete(User User);

	User findById(Long cust_id);
	User findByName(User user);
	List<User> findAllByHQL();
	List<User> findAllByQBC();
	List<User> findAllByNamedQuery();

}
