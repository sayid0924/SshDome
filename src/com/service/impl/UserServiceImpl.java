package com.service.impl;

import com.dao.UserDao;
import com.domain.User;
import com.domain.User;
import com.service.UserService;
import com.utils.MD5Utils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 用户管理的Service的实现类
 * @author jt
 *
 */
@Transactional
public class UserServiceImpl implements UserService {

	// 注入DAO:
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save(User user) {
//	System.out.println("Service中的save方法执行了...");
		userDao.save(user);
	}

	@Override
	public void update(User User) {
		userDao.update(User);
	}

	@Override
	public void delete(User User) {
		userDao.delete(User);
	}

	@Override
	public User findById(Long cust_id) {
		return userDao.findById(cust_id);
	}

	@Override
	public User findByName(User user) {
		return userDao.findByName(user);
	}

	@Override
	public List<User> findAllByHQL() {
		return userDao.findAllByHQL();
	}

	@Override
	public List<User> findAllByQBC() {
		return userDao.findAllByQBC();
	}

	@Override
	public List<User> findAllByNamedQuery() {
		return userDao.findAllByNamedQuery();
	}



}
