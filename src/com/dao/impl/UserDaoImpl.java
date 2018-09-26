package com.dao.impl;

import com.dao.UserDao;
import com.domain.User;
import com.domain.User;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 用户管理的DAO的实现类
 *
 * @author jt
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public void save(User User) {
        System.out.println("DAO中的save方法执行了...");
        this.getHibernateTemplate().save(User);
    }

    @Override
    public void update(User User) {
        this.getHibernateTemplate().update(User);
    }

    @Override
    public void delete(User User) {
        this.getHibernateTemplate().delete(User);
    }

    @Override
    public User findById(Long cust_id) {
        //  return this.getHibernateTemplate().get(User.class, cust_id);
        return this.getHibernateTemplate().load(User.class, cust_id);
    }

    @Override
    public User findByName(User user) {

        User u = new User();
        //必须 符合的条件但是这两个条件时并列的（象当于sql中的and）
        u.setUser_code(user.getUser_code());
        u.setUser_name(user.getUser_name());
        List<User> list = this.getHibernateTemplate().findByExample(u);

        if (list.size() != 0) {
            return list.get(0);
        } else {
            return null;
        }

    }

    @Override
    public List<User> findAllByHQL() {
        List<User> list = (List<User>) this.getHibernateTemplate().find("from User");
        return list;
    }

    @Override
    public List<User> findAllByQBC() {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(criteria);
        return list;
    }

    @Override
    public List<User> findAllByNamedQuery() {
        return (List<User>) this.getHibernateTemplate().findByNamedQuery("queryAll");
    }

}
