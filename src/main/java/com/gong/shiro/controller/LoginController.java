package com.gong.shiro.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gong.shiro.service.UserService;



@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/index")
	public String doIndex(Model model, HttpServletRequest request){
		Subject user = SecurityUtils.getSubject();
		boolean isLogin = user.isAuthenticated();
		if(!isLogin) return "login";
		return "index";
	}


	@RequestMapping(value="/login")
	public String doLogin(Model model, HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Subject user = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(true);
		
		user.login(token);
		
		boolean isLogin = user.isAuthenticated();
		
		
		model.addAttribute("liming", token.getUsername());
		return "redirect:/index";
	}
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String doLogOut(Model model, HttpServletRequest request){
		Subject user = SecurityUtils.getSubject();
		//boolean result = user.hasRole("admin");
		System.out.println("logout");
		if(null != user) user.logout();
		
		HttpSession session = request.getSession(false);
    	if(null != session) session.invalidate();
    	
		return "login";
	}
	

	@RequestMapping(value="/dopage_1")
	//@RequiresRoles("admin")
	public String doGetdata(Model model, HttpServletRequest request){
		
		/*Subject user = SecurityUtils.getSubject();
		
		boolean isPermitted = user.isPermitted(request.getRequestURI());
		*/
	    String result = "dopage_1";
		model.addAttribute("liming", result);
		return "page";
	}
	
	

	@RequestMapping(value="/dopage_2")
	public String doGetdata2(Model model){
	    String result = "dopage_2";
		model.addAttribute("liming", result);
		return "page2";
	}
	

	@RequestMapping(value="/errorpage")
	public String doErrorPage(Model model){
	    String result = "error_404";
		model.addAttribute("error_404", result);
		return "error_404";
	}
	
	
	
	
	
		
}
