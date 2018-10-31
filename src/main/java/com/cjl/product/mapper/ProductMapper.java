/**
 * 
 */
package com.cjl.product.mapper;


import java.util.List;

import com.cjl.product.model.ProductModel;
import com.cjl.product.vo.ProductVO;

import tk.mybatis.mapper.common.Mapper;

/**
 @author： fu    @time：2018年10月28日 下午8:24:33 
 @说明： 一份耕耘，一份收获
**/
public interface ProductMapper extends Mapper<ProductModel> {


	/**
	 * @param productVO 
	 * @说明：
	 */
	List<ProductModel> findProductList(ProductVO productVO);

	
}
