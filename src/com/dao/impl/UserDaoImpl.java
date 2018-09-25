package com.dao.impl;

import com.dao.UserDao;
import com.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 用户管理的DAO的实现类
 * @author jt
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	// DAO中保存用户的方法
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

}
