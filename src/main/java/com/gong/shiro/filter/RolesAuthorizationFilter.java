package com.gong.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

public class RolesAuthorizationFilter extends AuthorizationFilter{
	  @Override  
	    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)  
	            throws Exception {  
	        Subject subject = getSubject(request, response);   
	        String[] rolesArray = (String[]) mappedValue;   
	  
	        if (rolesArray == null || rolesArray.length == 0) {   
	            //no roles specified, so nothing to check - allow access.   
	            return true;   
	        }   
	  
	        for(int i=0;i<rolesArray.length;i++){    
	            if(subject.hasRole(rolesArray[i])){    
	                return true;    
	            }    
	        }    
	        return false;    
	    }  
	  
}
