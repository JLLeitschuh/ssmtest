package com.cjl.mapper;

import com.cjl.model.UserModel;

public interface UserMapper {
	
   //  @Select("SELECT * FROM func_user WHERE id = #{id}")
	  UserModel selectUserById(Long id);
	  
	//  @Select("insert into func_user(name,sex) values(#{name}, #{sex})")
	  int insertUser(UserModel userModel);
	  
	  void deleteUserById(Long id);
		
	  void updateUserById(UserModel	userModel);
	   
	}