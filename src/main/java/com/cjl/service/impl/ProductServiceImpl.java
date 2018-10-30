/**
 * 
 */
package com.cjl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjl.mapper.ProductMapper;
import com.cjl.model.ProductModel;
import com.cjl.service.ProductService;
import com.sun.tools.javac.util.List;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 @author： fu    @time：2018年10月28日 下午8:27:41 
 @说明： 一份耕耘，一份收获
**/
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public void insertProduct(ProductModel productModel) {
		productMapper.insert(productModel);
		
	}
	
	@Override
	public ProductModel selectProductById(Long id) {
		return productMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteProductById(Long id) {
		productMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void updateProductById(ProductModel productModel) {
		productMapper.updateByPrimaryKey(productModel);
	}

	@Override
	public List<ProductModel> queryByKeyWords(String keyWords) {
		Example example = new Example(ProductModel.class);
		Criteria criteria = example.createCriteria();
		criteria.andLike("productName","%"+keyWords+"%");
		return (List<ProductModel>) productMapper.selectByExample(example);
	}

	@Override
	public java.util.List<ProductModel> findAll() {
		return productMapper.selectAll();
	}



	
}
