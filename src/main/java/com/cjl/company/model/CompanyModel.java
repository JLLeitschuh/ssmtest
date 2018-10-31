/**
 * 
 */
package com.cjl.company.model;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 @author： fu    @time：2018年10月31日 上午9:07:45 
 @说明： 一份耕耘，一份收获
**/
@Table(name="func_company")
public class CompanyModel {

	/*
	 * 公司Id
	 */
	@Column(name="id")
	private long id;
	
	/*
	 * 公司名称
	 */
	@Column(name="company_name")
	private String companyName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "CompanyModel [id=" + id + ", companyName=" + companyName + "]";
	}
	
	
	
	
}
