/**
 * 
 */
package com.cjl.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjl.company.model.CompanyModel;
import com.cjl.company.service.CompanyService;
import com.cjl.product.model.ProductModel;
import com.cjl.product.service.ProductService;
import com.cjl.product.vo.ProductVO;
import com.github.pagehelper.PageInfo;

import base.util.JsonMsg;

/**
 * @author： fu @time：2018年10月28日 下午8:25:28 @说明： 一份耕耘，一份收获
 **/
@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CompanyService companyService;

	/*
	 * 跳转用户列表界面
	 */
	@RequestMapping("to_product_list")
	public String toProductList(ProductVO vo, HttpServletRequest request) {

		List<CompanyModel> companyList = companyService.findAll();
		PageInfo<ProductModel> pageInfo = productService.findPageInfo(vo);
		request.setAttribute("vo", vo);
		request.setAttribute("companyList", companyList);
		request.setAttribute("pageInfo", pageInfo);
		return "product/product_list2";
	}

	/*
	 * 跳转添加产品页面,需要company的下拉列表
	 */
	@RequestMapping("to_add_product")
	public String toAddProduct(HttpServletRequest request) {
		List<CompanyModel> companyList = companyService.findAll();
		request.setAttribute("companyList", companyList);
		return "product/add_product";
	}

	/*
	 * 添加产品,得到下拉列表的内容,和input text的内容
	 */
	@RequestMapping("do_add_product")
	@ResponseBody
	public JsonMsg doAddProduct(ProductModel productModel, String productTimeStr)
			throws ParseException {
		JsonMsg ret = new JsonMsg("添加产品失败!");
		ret.setSuccess(true);
		ret.setMsg("添加产品成功");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Date date = sdf.parse(productTimeStr);
		productModel.setProductName(productTimeStr);

		int number = productService.insertProduct(productModel);

		if (number == 1) {
			ret.setSuccess(true);
			ret.setMsg("添加产品成功");
		} else {
			ret.setSuccess(false);
			ret.setMsg("添加产品失败");
		}
		return ret;
	}

	/*
	 * 跳转编辑页面
	 */
	@RequestMapping("to_update_product")
	public String toUpdateUser(HttpServletRequest request, Long productId) {

		// 编辑页面需要ProductModel的所有属性
		ProductModel productModel = productService.findProductById(productId);
		List<CompanyModel> companyList = companyService.findAll();
		request.setAttribute("companyList", companyList);
		request.setAttribute("model", productModel);
		return "product/update_product";
	}

	/*
	 * 编辑页面内容,修改操作
	 */
	
	@RequestMapping("do_update_product")
	@ResponseBody
	public JsonMsg doUpdateProduct(ProductModel productModel,String productTimeStr) {
		JsonMsg ret = new JsonMsg("修改产品成功");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		try {
			Date date = sdf.parse(productTimeStr);
			productModel.setProductTime(date);
			int flag = productService.updateProductById(productModel);
			if (flag > 0) {
				ret.setSuccess(true);
				ret.setMsg("修改产品成功");
			}
		} catch (ParseException e1) {
			ret.setSuccess(false);
			ret.setMsg("修改产品失败");
			e1.printStackTrace();
		}
		return ret;
	}

	@RequestMapping("do_delete_product")
	@ResponseBody
	public JsonMsg toDeleteProduct(Long productId){
		JsonMsg ret=new JsonMsg("删除成功");
		try {
			int flag=productService.deleteProductById(productId);
			if (flag>0) {
				ret.setMsg("删除成功");
				ret.setSuccess(true);
			}
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			ret.setMsg("删除失败");
			ret.setSuccess(false);
		}
		return ret;
	}
	
	// 下面是之前的代码===============================================================

	/*
	 * 增加用户
	 */
	/*
	 * @RequestMapping(value="insert_product") public String
	 * insertProduct(ProductModel productModel,Model model) {
	 * productModel.setProductName("product34");
	 * productModel.setProductPrice(12); productModel.setProductTime(new
	 * Date()); productService.insertProduct(productModel); return
	 * "product/insert"; }
	 * 
	 * 
	 * 根据Id查询用户
	 * 
	 * @RequestMapping(value="select_product/{id}") //@ResponseBody public
	 * String selectProduct(@PathVariable Long id,Model model){ ProductModel
	 * productModel=productService.selectProductById(id);
	 * model.addAttribute("productModel",productModel);
	 * System.out.println(productModel.getProductName()); return
	 * "product/select"; }
	 * 
	 * 
	 * 根据Id查询用户2,根据HttpServletRequest传值
	 * 
	 * @RequestMapping(value="select_product2/{id}") //@ResponseBody public
	 * String selectProduct2(@PathVariable Long id,HttpServletRequest request){
	 * ProductModel productModel=productService.selectProductById(id);
	 * request.setAttribute("productModel",productModel);
	 * System.out.println(productModel.getProductName()); return
	 * "product/select"; }
	 * 
	 * 
	 * 删除用户
	 * 
	 * @RequestMapping(value="delect_product/{id}") public String
	 * deleteProductById(@PathVariable long id) {
	 * productService.deleteProductById(id); return "product/delete"; }
	 * 
	 * 
	 * 通过id修改用户
	 * 
	 * @RequestMapping(value="update_product") public String
	 * updateProductById(ProductModel productModel) { productModel.setId(2l);
	 * productModel.setProductName("product1");
	 * productModel.setProductPrice(155); productModel.setProductTime(new
	 * Date()); productService.updateProductById(productModel); return
	 * "product/update"; }
	 * 
	 * // 关键字查询
	 * 
	 * @GetMapping("/selectByKeyWords/{keyWords}") public String
	 * selectKeyWords(@PathVariable String keyWords){
	 * 
	 * List<ProductModel> list = productService.queryByKeyWords(keyWords); for
	 * (ProductModel productModel : list) { System.out.println(productModel); }
	 * return "product/success"; }
	 */

}
