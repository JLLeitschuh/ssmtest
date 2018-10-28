package com.cjl.service;

import com.cjl.model.UserModel;



public interface UserService {

	public void insertUser(UserModel userModel);
	
	public UserModel selectUserById(Long id);
	
	public void deleteUserById(Long id);
	
	public void updateUserById(UserModel userModel);
	
	public UserModel selectUserByUserNameAndEntryDate(String userName);
}
