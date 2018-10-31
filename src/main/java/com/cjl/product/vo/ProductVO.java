/**
 * 
 */
package com.cjl.product.vo;

import base.util.BaseVo;

/**
 @author： fu    @time：2018年10月31日 上午10:02:45 
 @说明： 一份耕耘，一份收获
**/
public class ProductVO extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long companyId;
	
	private String productName;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
