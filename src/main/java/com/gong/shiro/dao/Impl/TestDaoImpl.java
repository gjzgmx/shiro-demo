package com.gong.shiro.dao.Impl;

import org.springframework.stereotype.Repository;

import com.gong.shiro.dao.TestDao;
import com.gong.shiro.entity.User;

/**
 * 
 * @author gongjz
 *
 */
@Repository
public class TestDaoImpl implements TestDao {

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
