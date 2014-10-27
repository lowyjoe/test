package com.lim.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lim.dao.TreeDao;

public class EasyTreeEdite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//测试数据
	/*Map<String, Object> tree = new HashMap<String, Object>();
	tree.put("success", "true");
	tree.put("msg", "添加成功");
	JSONArray json=JSONArray.fromObject(tree);
	response.getWriter().write(json.toString()); */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String text=   request.getParameter("text");
		String id=request.getParameter("id");
		TreeDao dao=new TreeDao();

		try {
			 dao.update(id, text);
		} catch (Exception e) {
			response.getWriter().print("{\"success\":false,\"msg\":\"修改失败\"}");
			e.printStackTrace();
		}
		System.out.println(">>>>>>>>>>text::"+text+">>>>>>>> id >>>"+id );
		 response.getWriter().print("{\"success\":true,\"msg\":\"修改菜单成功\"}");
		
	
	}

}
