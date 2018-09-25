package com.web.action;

import com.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;

/**
 * 用户管理的Action的类
 * @author jt
 *
 */

public class UserAction extends ActionSupport implements ModelDriven<User> {
	// 模型驱动使用的对象
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}

	// 注入Service:
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 用户注册的方法:regist
	 */

	public String regist(){
		userService.regist(user);
		return LOGIN;
	}

}
