package com.web.action;

import com.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;
import com.utils.MD5Utils;

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
	 * 用户登录的方法
	 */

	public String userLogin(){
		if (userService.findByName(user) != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * 用户注册的方法:regist
	 */


	public String userRegist(){
		// 对密码进行加密处理：
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		user.setUser_state("1");
		userService.save(user);
		return "success";
	}

}
