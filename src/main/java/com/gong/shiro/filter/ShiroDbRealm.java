package com.gong.shiro.filter;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.gong.shiro.entity.User;
import com.gong.shiro.service.ResourcesService;
import com.gong.shiro.service.RoleService;
import com.gong.shiro.service.UserService;


public class ShiroDbRealm extends AuthorizingRealm  {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourcesService resourcesService;
	
	

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
	            PrincipalCollection principals) throws AuthenticationException{
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		String userName = (String)getAvailablePrincipal(principals);
		
	    User user = userService.getUserByUserName(userName);
	    if(null == user) throw new IncorrectCredentialsException();
	    
	    List<String> roles = roleService.getRoleByUserName(user.getUserName());
	    if(null == roles) throw new AuthenticationException();
	    
	    List<String> resourcUrls = null;
	    for (String roleName : roles) {
	    	resourcUrls = resourcesService.getResourcesByRole(roleName);
		}
	    
	    if(null == resourcUrls) throw new AuthenticationException();
	    
	  

        info.addRoles(roles);
        info.addStringPermissions(resourcUrls);
	    return info;
	 }


	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo (
			AuthenticationToken authToken) throws AuthenticationException {
		UsernamePasswordToken token =  (UsernamePasswordToken)authToken;
		if(null == token || null == token.getUsername()){
			throw new UnknownAccountException();
		}
		User user = userService.getUserByUserName(token.getUsername());
		
		if(null == user)  throw new UnknownAccountException();//throw new IncorrectCredentialsException();
		
		return new SimpleAuthenticationInfo(user.getUserName(),
				user.getPassWord(),getName());

	}
	
	

}
