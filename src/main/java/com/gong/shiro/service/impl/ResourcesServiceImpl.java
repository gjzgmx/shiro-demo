package com.gong.shiro.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gong.shiro.service.ResourcesService;

/**
 * 
 * @author gongjz
 *
 */

@Service
public class ResourcesServiceImpl implements ResourcesService{

	private static final  Map<String,List<String>> resouceMap = new HashMap<String,List<String>>();
	
	static{
		List<String> resouceUrls = new ArrayList<String>();
		resouceUrls.add("/shiro/getdata");
		resouceUrls.add("/shiro/getdata2");
		/*resouceUrls.add("/login.do");*/
		resouceMap.put("admin", resouceUrls);
		resouceUrls = new ArrayList<String>();
		resouceUrls.add("/shiro/getdata2");
		resouceMap.put("guest", resouceUrls);
	}
	
	
	@Override
	public List<String> getResourcesByRole(String roleName){
		List<String> resouceList = resouceMap.get(roleName);
		return resouceList;
	}
	
	
	
}
