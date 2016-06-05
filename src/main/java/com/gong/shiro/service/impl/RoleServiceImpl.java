package com.gong.shiro.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gong.shiro.service.RoleService;

/**
 * 
 * @author gongjz
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

private static final  Map<String,List<String>> RoleMap = new HashMap<String,List<String>>();
	
	static{
		List<String> roleName = new ArrayList<String>();
		roleName.add("admin");
		RoleMap.put("admin", roleName);
		roleName = new ArrayList<String>();
		roleName.add("guest");
		RoleMap.put("guest", roleName);
	}
	
	
	@Override
	public List<String> getRoleByUserName(String userName){
		List<String> roleNameList = RoleMap.get(userName);
		return roleNameList;
	}
	
}
