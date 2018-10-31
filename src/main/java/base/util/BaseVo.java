/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: BaseVo.java 
 *
 * @Date:  2016年9月27日  下午3:44:26
 *
 * @Package com.dossp.ods.dms.common.model
 */


package base.util;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年9月27日 下午3:44:26
 * </p>
 * 描述：公共VO
 *
 */

public abstract class BaseVo implements Serializable {
	
	private static final Logger log = LoggerFactory.getLogger(BaseVo.class);
	/** 
	 * 
	 * @Fields serialVersionUID
	 */ 
	private static final long serialVersionUID = -9207617274484992112L;

	/**
	 * 当前页码，默认为1
	 */
	private String pageNum = "1";

	/**
	 * 每页多少条，默认为10条
	 */
	private String pageSize = "10";
	
	/**
	 * 排序字段
	 */
	private String orderField;

	/**
	 * 排序方向，默认ASC
	 */
	private String orderDirection = "ASC";

	/**
	 * @return the pageNum
	 */
	public int getPageNum() {
		int num = 1;
		try {
			num = Integer.parseInt(pageNum);
		} catch (NumberFormatException e) {
			// 如果出错，则为默认值1
			log.debug("当前页码数转换出错，改为默认值1。", e);
		}
		return num;
	}

	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		int size = 10;
		try {
			size = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			// 如果出错，则为默认值10
			log.debug("每页记录数转换出错，改为默认值10。", e);
		}
		return size;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the orderField
	 */
	public String getOrderField() {
		return orderField;
	}

	/**
	 * @param orderField the orderField to set
	 */
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	/**
	 * @return the orderDirection
	 */
	public String getOrderDirection() {
		return orderDirection;
	}

	/**
	 * @param orderDirection the orderDirection to set
	 */
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	/** 
	 * @return 
	 */
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
