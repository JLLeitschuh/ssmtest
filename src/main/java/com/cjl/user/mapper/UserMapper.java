package com.cjl.user.mapper;


import com.cjl.user.model.UserModel;

import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<UserModel>{
	
   //  @Select("SELECT * FROM func_user WHERE id = #{id}")
	  UserModel selectUserById(Long id);
	  
	//  @Select("insert into func_user(name,sex) values(#{name}, #{sex})")
	  int insertUser(UserModel userModel);
	  
	  void deleteUserById(Long id);
		
	  void updateUserById(UserModel	userModel);
	  
	  UserModel selectUserByUserNameAndEntryDate(String userName);
	   
	}