/**
 * 
 */
package com.cjl.product.service;

import java.util.List;

import com.cjl.product.model.ProductModel;
import com.cjl.product.vo.ProductVO;
import com.github.pagehelper.PageInfo;

/**
 @author： fu    @time：2018年10月28日 下午8:26:30 
 @说明： 一份耕耘，一份收获
**/
public interface ProductService {

	public void insertProduct(ProductModel productModel);
	
	public ProductModel selectProductById(Long id);
	
	public void deleteProductById(Long id);
	
	public void updateProductById(ProductModel productModel);
	
	public List<ProductModel> queryByKeyWords(String keyWords);

	/**
	 * @说明：
	 */
	public java.util.List<ProductModel> findAll();

	/**
	 * @说明：
	 */
	public PageInfo<ProductModel> findPageInfo(ProductVO productVO);
}
