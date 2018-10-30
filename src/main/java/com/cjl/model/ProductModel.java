/**
 * 
 */
package com.cjl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Long id;
	
	/*
	 *产品名称 
	 */
	@Column(name="product_name")
	private String productName;
	
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
	
	
	
	public Date getProductTime() {
		return productTime;
	}

	public void setProductTime(Date productTime) {
		this.productTime = productTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productTime=" + productTime + "]";
	}


	

	
}
