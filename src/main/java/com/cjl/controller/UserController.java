/**
 * @copy right Stateally Interactive Company All rights reserved
 *
 * @Title: userController.java 
 *
 * @Date:  2018年10月24日  下午4:57:34
 *
 * @Package cn.com.wmc.controller
 */


package com.cjl.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjl.UserForm;
import com.cjl.model.UserModel;
import com.cjl.service.UserService;


/**
 * @author fuhuifang
 * 
 * 日期：2018年10月24日 下午4:57:34
 *
 * 描述：
 * @version V1.0
 *
 */
@Controller  
/*@RequestMapping(value = "func/user")*/
public class UserController {

	@Autowired
	private UserService userService;
	
	/*
	 * 增加用户
	 */
	@RequestMapping(value="insert_user")
	public String insertUser(UserForm userForm,Model model) {
		UserModel userModel=new UserModel();
		userModel.setUserName("FUHUIFANG");
		userModel.setEntryDate(new Date());
		userModel.setUserSex("nv");
		userService.insertUser(userModel);
		return "user/insert";
	}
	
	
	/*
	 * 根据Id查询用户
	 */
	@RequestMapping(value="select_user/{id}")
	//@ResponseBody
	public String selectUser(@PathVariable Long id,Model model){
		UserModel userModel=userService.selectUserById(id);
		model.addAttribute("userModel",userModel);
		System.out.println(userModel.getUserName());
		return "user/selectUser";
	}
	
	/*
	 * 删除用户
	 */
	@RequestMapping(value="delect_user/{id}")
	public String deleteUserById(@PathVariable long id) {
		userService.deleteUserById(id);
		return "user/delete";
	}
	
	/*
	 * 通过id修改用户
	 */
	@RequestMapping(value="update_user")
	public String updateUserById(UserForm userForm) {
		UserModel userModel=new UserModel();
		userModel.setId(2l);
		userModel.setUserName("ww");
		userModel.setUserSex("nan");
		userModel.setEntryDate(new Date());
		userService.updateUserById(userModel);
		
		return "user/update";
		
	}
	
	/*	@Test
	public void selectUserTest(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				   new String[] {"applicationContext-mybatis.xml","mybatis-config.xml"});
		UserService userService= context.getBean(UserService.class);
		System.out.println(userService+"--");
		UserModel userModel=userService.selectUserById(2L);
		System.out.println(userModel.getUserName());
	}*/
	
	
}
