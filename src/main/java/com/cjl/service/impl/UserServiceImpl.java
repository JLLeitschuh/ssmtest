/**
 * 
 */
package com.cjl.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjl.mapper.UserMapper;
import com.cjl.model.UserModel;
import com.cjl.service.UserService;



/**
 @author： fu    @time：2018年10月23日 下午3:11:21 
 @说明： 一份耕耘，一份收获
**/
@Service
public class UserServiceImpl implements UserService{

	@Autowired 
	private UserMapper userMapper;
	/* (non-Javadoc)
	 * @see cn.com.wmc.service.UserService#insert()
	 */
	@Override
	public void insertUser(UserModel userModel) {
	  userMapper.insertUser(userModel);
	}
	
	@Override
	public UserModel selectUserById(Long id) {
		return userMapper.selectUserById(id);
	}


	/* (non-Javadoc)
	 * @see com.cjl.service.UserService#updateUserById(java.lang.Long)
	 */
	@Override
	public void updateUserById(UserModel userModel) {
		userMapper.updateUserById(userModel);
	}

	/* (non-Javadoc)
	 * @see com.cjl.service.UserService#deleteUserById(java.lang.Long)
	 */
	@Override
	public void deleteUserById(Long id) {
		userMapper.deleteUserById(id);
		
	}

}
