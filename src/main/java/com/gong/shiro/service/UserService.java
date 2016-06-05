package com.gong.shiro.service;

import com.gong.shiro.entity.User;


public interface UserService {

	public User getUserByUserNameAndPwd(String userName, String pwd) ;
	
	public User getUserByUserName(String userName);
}
