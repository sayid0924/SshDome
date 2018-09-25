package com.service.impl;

import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;
import com.utils.MD5Utils;
import org.springframework.transaction.annotation.Transactional;


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
	// 业务层注册用户的方法
	public void regist(User user) {
		// 对密码进行加密处理：
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		user.setUser_state("1");
		// 调用DAO
		userDao.save(user);
	}

}
