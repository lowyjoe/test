package com.lim.action;

import com.lim.base.ActionBase;
import com.lim.dao.TreeDao;

public class EasyTreeDel extends ActionBase {
	private String id;
	private String text;
	private TreeDao dao;
	public TreeDao getDao() {
		return dao;
	}

	public void setDao(TreeDao dao) {
		this.dao = dao;
	}
	public void EasyTreeDel() throws Exception{
		 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>删除id:"+id+"?????text:"+text);
		 try {
			dao.delete(id);
		} catch (Exception e) {
			 response.getWriter().write("{\"success\":false,\"msg\":\"删除菜单失败,原因"+e.toString()+"\"}");
			e.printStackTrace();
		}
		 response.getWriter().write("{\"success\":true,\"msg\":\"删除菜单成功,名称>" + text + ",id>" + id + "\"}");
	}
	 
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	};

 
}
