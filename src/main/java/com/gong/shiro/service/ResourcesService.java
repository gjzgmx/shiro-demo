package com.gong.shiro.service;

import java.util.List;


public interface ResourcesService {

	public List<String> getResourcesByRole(String roleName);
	
}
