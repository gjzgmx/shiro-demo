package com.gong.shiro.dao;

import com.gong.shiro.entity.User;


public interface TestDao {

	public User getUserByUserNameAndPwd(String userName, String pwd) ;
	
	public User getUserByUserName(String userName);
}
