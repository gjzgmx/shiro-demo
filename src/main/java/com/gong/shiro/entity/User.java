package com.gong.shiro.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;





/**
 * 用户
 * 
 */
public class User implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 12345678234L;


	/**
	 * 名称
	 */
	private String userName;


	/**
	 * 密码
	 */
	private String passWord;

	

	
	/**
	 * 有效  0-有效 1-无效
	 */
	private Integer  isValid;
    

    public User getUserByUserName(String userName){
    	if(isExistsUser(userName)) return getUser(userName,"123456",0);;
    	return null;
    }

    public User getUserByUserNameAndPwd(String userName, String passWord){
    	if(isExistsUser(userName, passWord)) 
    	return getUser(userName,passWord,0);
    	return null;
    }

    private User getUser(String userName, String passWord,Integer isValid){
    	User user = new User();
    	user.setUsername(userName);
    	user.setPassword(passWord);
    	user.setIsValid(isValid);
    	return user;
    }
   
   private boolean isExistsUser(String userName){
	   if(userName.equals("admin") || userName.equals("guest")){
		   return true;
	   }
	   return false;
   }
   
   private boolean isExistsUser(String userName, String passWord){
	   String requestData = userName +"_"+passWord;
	   if(requestData.equals("admin_12346")  || userName.equals("guest_123456")){
		   return true;
	   }
	   return false;
   }


	public String getUserName() {
		return userName;
	}




	public void setUsername(String userName) {
		this.userName = userName;
	}




	public String getPassWord() {
		return passWord;
	}




	public void setPassword(String passWord) {
		this.passWord = passWord;
	}




	public Integer getIsValid() {
		return isValid;
	}




	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}



   
	
	
	

    
	
}
