/**
 * 
 */
package com.cjl.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjl.company.mapper.CompanyMapper;
import com.cjl.company.model.CompanyModel;
import com.cjl.company.service.CompanyService;

/**
 @author： fu    @time：2018年10月31日 上午10:38:21 
 @说明： 一份耕耘，一份收获
**/
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyMapper companyMapper;
	
	@Override
	public List<CompanyModel> findAll() {
		return companyMapper.selectAll();
	}

}
