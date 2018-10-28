/**
 * 
 */
package com.cjl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjl.mapper.ProductMapper;
import com.cjl.model.ProductModel;
import com.cjl.service.ProductService;

/**
 @author： fu    @time：2018年10月28日 下午8:27:41 
 @说明： 一份耕耘，一份收获
**/
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;

	/* (non-Javadoc)
	 * @see com.cjl.service.ProductService#insertProduct(com.cjl.model.ProductModel)
	 */
	@Override
	public void insertProduct(ProductModel productModel) {
		productMapper.insert(productModel);
		
	}

	/* (non-Javadoc)
	 * @see com.cjl.service.ProductService#selectProductById(java.lang.Long)
	 */
	@Override
	public ProductModel selectProductById(Long id) {
		return productMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.cjl.service.ProductService#deleteProductById(java.lang.Long)
	 */
	@Override
	public void deleteProductById(Long id) {
		productMapper.deleteByPrimaryKey(id);
		
	}

	/* (non-Javadoc)
	 * @see com.cjl.service.ProductService#updateProductById(com.cjl.model.ProductModel)
	 */
	@Override
	public void updateProductById(ProductModel productModel) {
		productMapper.updateByPrimaryKey(productModel);
	}

	
}
