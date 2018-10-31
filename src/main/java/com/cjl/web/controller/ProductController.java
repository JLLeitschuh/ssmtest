/**
 * 
 */
package com.cjl.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjl.product.model.ProductModel;
import com.cjl.product.service.ProductService;



/**
 @author： fu    @time：2018年10月28日 下午8:25:28 
 @说明： 一份耕耘，一份收获
**/
@Controller
@RequestMapping(value="/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	 
	
	/*
	 * 跳转用户列表界面
	 */
	@RequestMapping(value="to_user_list")
	public String toProductList(HttpServletRequest request){
		
		
		List<ProductModel> list=productService.findAll();
		for (ProductModel productModel : list) {
			System.out.println(productModel);
		}
		request.setAttribute("list", list);
		return "product/product_list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//下面是之前的代码====================================================
	
	
	/*
	 * 增加用户
	 */
	@RequestMapping(value="insert_product")
	public String insertProduct(ProductModel productModel,Model model) {
		productModel.setProductName("product34");
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
		return "product/select";
	}
	
	/*
	 * 根据Id查询用户2,根据HttpServletRequest传值
	 */
	@RequestMapping(value="select_product2/{id}")
	//@ResponseBody
	public String selectProduct2(@PathVariable Long id,HttpServletRequest request){
		ProductModel productModel=productService.selectProductById(id);
		request.setAttribute("productModel",productModel);
		System.out.println(productModel.getProductName());
		return "product/select";
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
	public String updateProductById(ProductModel productModel) {
		productModel.setId(2l);
		productModel.setProductName("product1");
		productModel.setProductPrice(155);
		/*productModel.setProductTime(new Date());*/
		productService.updateProductById(productModel);
		return "product/update";
	}
	
	// 关键字查询
	@GetMapping("/selectByKeyWords/{keyWords}") 
	public String selectKeyWords(@PathVariable String keyWords){
		
				List<ProductModel> list = productService.queryByKeyWords(keyWords);
				for (ProductModel productModel : list) {
					System.out.println(productModel);
				}
				return "product/success";
		}
	
}
