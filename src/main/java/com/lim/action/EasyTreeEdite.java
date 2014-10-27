package com.lim.action;

import com.lim.base.ActionBase;
import com.lim.dao.TreeDao;

public class EasyTreeEdite extends ActionBase {
	private String id;
	private String text;
	private TreeDao dao;
	public TreeDao getDao() {
		return dao;
	}

	public void setDao(TreeDao dao) {
		this.dao = dao;
	}
	public void EasyTreeEdite() throws Exception{

		try {
			 dao.update(id, text);
		} catch (Exception e) {
			response.getWriter().print("{\"success\":false,\"msg\":\"修改失败\"}");
			e.printStackTrace();
		}
		System.out.println(">>>>>>>>>>text::"+text+">>>>>>>> id >>>"+id );
		 response.getWriter().print("{\"success\":true,\"msg\":\"修改菜单成功\"}");
		
	
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
