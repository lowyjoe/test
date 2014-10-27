/**
 * ActionBase.java 2008-9-11 下午08:58:56 
 * Copyright XMBCIT 2008-2010
 */
package com.lim.base;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 所有Action的父类
 * @author dlwu
 *
 */
@SuppressWarnings("serial")
public abstract class ActionBase extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	protected final String CONTENTTYPE_JSON = "text/json;charset=UTF-8";
	protected final String CONTENTTYPE_HTML = "text/html;charset=UTF-8";
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	/**
	 * 获取ActionContext
	 * @return ActionContext
	 * @author: zhlong
	 * @version: 2013-4-18 下午06:29:52
	 */
	protected ActionContext getActionContext(){		
		return ActionContext.getContext();
	}
	/**
	 * 通过response将消息输出到前端
	 * @param contentType
	 * @param result
	 * @throws Exception void
	 * @author: zhlong
	 * @version: 2013-3-21 上午09:32:32
	 */
	protected void write(String contentType,String result) throws Exception{
		System.out.println("Action type" + contentType + ",result>>>>>>>>>>"+result);
		response.setContentType(contentType);
		response.getWriter().write(result);
	}
}
