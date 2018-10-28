/**
 * 
 */
package com.cjl.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjl.form.ProductForm;
import com.cjl.model.ProductModel;
import com.cjl.service.ProductService;

/**
 @author： fu    @time：2018年10月28日 下午8:25:28 
 @说明： 一份耕耘，一份收获
**/
@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	/*
	 * 增加用户
	 */
	@RequestMapping(value="insert_product")
	public String insertProduct(ProductForm productForm,Model model) {
		ProductModel productModel=new ProductModel();
		productModel.setProductName("product3");
		productModel.setProductPrice(12);
		productModel.setProductTime(new Date());
		productService.insertProduct(productModel);
		return "product/insert";
	}
	
	/*
	 * 根据Id查询用户
	 */
	@RequestMapping(value="select_product/{id}")
	//@ResponseBody
	public String selectProduct(@PathVariable Long id,Model model){
		ProductModel productModel=productService.selectProductById(id);
		model.addAttribute("productModel",productModel);
		System.out.println(productModel.getProductName());
		return "product/selectProduct";
	}
	
	/*
	 * 删除用户
	 */
	@RequestMapping(value="delect_product/{id}")
	public String deleteProductById(@PathVariable long id) {
		productService.deleteProductById(id);
		return "product/delete";
	}
	
	/*
	 * 通过id修改用户
	 */
	@RequestMapping(value="update_product")
	public String updateProductById(com.cjl.form.ProductForm productForm) {
		ProductModel productModel=new ProductModel();
		productModel.setId(2l);
		productModel.setProductName("product1");
		productModel.setProductPrice(10);
		productModel.setProductTime(new Date());
		productService.updateProductById(productModel);
		return "product/update";
		
	}
	
	
	
}