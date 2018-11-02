/**
 * 
 */
package com.cjl.product.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 @author： fu    @time：2018年10月28日 下午6:55:03 
 @说明： 一份耕耘，一份收获
**/
@Table(name="func_product")
public class ProductModel {

	/*
	 * 产品Id
	 */
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "id")
	private Long id;
	
	/*
	 * 产品公司主键
	 */
	@Column(name="company_id")
	private Long companyId;
	
	
	/*
	 *产品名称 
	 */
	@Column(name="product_name")
	private String productName;
	
	/*
	 * 公司名称
	 */
	@Transient
	private String companyName;
	
	/*
	 * 产品价格
	 */
	@Column(name="product_price")
	private float productPrice;

	/*
	 * 产品进货时间
	 */
	@Column(name="product_time")
	private Date productTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public Date getProductTime() {
		return productTime;
	}

	public void setProductTime(Date productTime) {
		this.productTime = productTime;
	}


	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
	
}
