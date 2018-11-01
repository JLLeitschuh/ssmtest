/**
 * 
 */
package com.cjl.product.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 @author： fu    @time：2018年11月1日 上午11:14:34 
 @说明： 一份耕耘，一份收获
**/
@Table(name="func_user_company")
public class ProductCompanyModel {

	/*
	 * 主键
	 */
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "id")
	private Long id;
	
	/*
	 * 产品主键
	 */
	@Column(name="product_id")
	private Long productId;
	
	/*
	 * 公司主键
	 */
	
	@Column(name="company_id")
	private Long companyId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "ProductCompanyModel [id=" + id + ", productId=" + productId + ", companyId="
				+ companyId + "]";
	}
	
	
}
