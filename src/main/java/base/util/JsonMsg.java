/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: JsonMsg.java 
 *
 * @Date:  2016年10月14日  下午3:24:58
 *
 * @Package com.dossp.mcprc.cnm.common.model
 */


package base.util;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年10月14日 下午3:24:58
 * </p>
 * 描述：
 *
 */

public class JsonMsg {
	
	private boolean success = false;

	private String msg = "";

	private Object obj = null;
	
	public JsonMsg() {
		super();
	}

	/**
	 * @param success
	 * @param msg
	 */
	public JsonMsg(String msg) {
		super();
		this.msg = msg;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the obj
	 */
	public Object getObj() {
		return obj;
	}

	/**
	 * @param obj the obj to set
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
