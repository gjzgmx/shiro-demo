package com.gong.shiro.service.impl;

import org.springframework.stereotype.Service;

import com.gong.shiro.entity.User;
import com.gong.shiro.service.UserService;

/**
 * 
 * @author gongjz
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Override
	public User getUserByUserNameAndPwd(String userName, String passWord) {
		User user = new User().getUserByUserNameAndPwd(userName, passWord);
		return user;
	}

	@Override
	public User getUserByUserName(String userName) {
		User user = new User().getUserByUserName(userName);
		return user;
	}

}
